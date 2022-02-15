package kz.stolik.servicebackendstolik.controller;

import kz.stolik.servicebackendstolik.exception.domain.InvalidUsernameOrPasswordException;
import kz.stolik.servicebackendstolik.model.dto.AuthToken;
import kz.stolik.servicebackendstolik.model.dto.LoginDtoRequest;
import kz.stolik.servicebackendstolik.model.dto.LoginDtoResponse;
import kz.stolik.servicebackendstolik.model.dto.UserDtoResponse;
import kz.stolik.servicebackendstolik.model.entity.User;
import kz.stolik.servicebackendstolik.service.UserService;
import kz.stolik.servicebackendstolik.service.impl.UserServiceImpl;
import kz.stolik.servicebackendstolik.utils.TokenProvider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final TokenProvider jwtTokenUtil;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public LoginController(AuthenticationManager authenticationManager, TokenProvider jwtTokenUtil, UserServiceImpl userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
        this.modelMapper = new ModelMapper();
    }

    @PostMapping
    public ResponseEntity<?> generateToken(@RequestBody LoginDtoRequest loginUser) throws AuthenticationException {
        User user = (User) userService.loadUserByUsername(loginUser.getUsername());
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginUser.getUsername(),
                            loginUser.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new InvalidUsernameOrPasswordException();
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new LoginDtoResponse(new AuthToken(token), modelMapper.map(user, UserDtoResponse.class)));
    }
}
