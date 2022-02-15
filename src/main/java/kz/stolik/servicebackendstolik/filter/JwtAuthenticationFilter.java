package kz.stolik.servicebackendstolik.filter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import kz.stolik.servicebackendstolik.constants.exception.TokenExpiredException;
import kz.stolik.servicebackendstolik.exception.domain.*;
import kz.stolik.servicebackendstolik.model.entity.User;
import kz.stolik.servicebackendstolik.service.impl.UserServiceImpl;
import kz.stolik.servicebackendstolik.utils.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static kz.stolik.servicebackendstolik.constants.SystemConstants.TOKEN_HEADER;
import static kz.stolik.servicebackendstolik.constants.SystemConstants.TOKEN_PREFIX;
import static kz.stolik.servicebackendstolik.constants.exception.AuthExceptionConstants.*;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private TokenProvider jwtTokenUtil;
    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;


    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(TOKEN_HEADER);
        String username = null;
        String authToken = null;
        System.out.println(header);
        if (header != null && header.startsWith(TOKEN_PREFIX)) {
            authToken = header.substring(7);
            System.out.println(authToken);
            try {
                username = jwtTokenUtil.getUsernameFromToken(authToken);
            }   catch (ExpiredJwtException e) {
                logger.error(TOKEN_EXPIRED_MESSAGE);
                resolver.resolveException(req, res, null, new TokenExpiredException());
            }   catch (IllegalArgumentException e) {
                logger.error(FETCH_USERNAME_FROM_TOKEN_ERROR_MESSAGE);
                resolver.resolveException(req, res, null, new FetchUsernameFromTokenException());
            }  catch(SignatureException e){
                logger.error(INVALID_USERNAME_OR_PASSWORD_MESSAGE);
                resolver.resolveException(req, res, null, new InvalidUsernameOrPasswordException());
            }  catch (MalformedJwtException e) {
                logger.error(INVALID_TOKEN_MESSAGE);
                resolver.resolveException(req, res, null, new InvalidTokenFormatException());
            }
        } else {
            logger.error(TOKEN_NOT_FOUND_MESSAGE);
            resolver.resolveException(req, res, null, new TokenNotFoundException());
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            User user = userService.loadUserByUsername(username);
            if (!user.isEnabled()) {
                logger.error(ACCOUNT_BLOCKED_MESSAGE);
                resolver.resolveException(req, res, null, new AccountBlockedException());
            }
            else if (jwtTokenUtil.validateToken(authToken, user)) {
                UsernamePasswordAuthenticationToken authentication = jwtTokenUtil.getAuthenticationToken(authToken, SecurityContextHolder.getContext().getAuthentication(), user);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
                logger.info("authenticated user " + username + ", setting security context");
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        chain.doFilter(req, res);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return new AntPathRequestMatcher("/users/**").matches(request) || new AntPathRequestMatcher("/auth").matches(request);
    }

}
