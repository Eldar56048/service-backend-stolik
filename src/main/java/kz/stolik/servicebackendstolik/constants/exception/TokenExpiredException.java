package kz.stolik.servicebackendstolik.constants.exception;

import kz.stolik.servicebackendstolik.exception.CustomException;
import org.springframework.http.HttpStatus;

import static kz.stolik.servicebackendstolik.constants.exception.AuthExceptionConstants.TOKEN_EXPIRED_MESSAGE;
import static kz.stolik.servicebackendstolik.constants.exception.AuthExceptionConstants.TOKEN_EXPIRED_CODE;

public class TokenExpiredException extends CustomException {
    public TokenExpiredException() {
        super(TOKEN_EXPIRED_MESSAGE, TOKEN_EXPIRED_CODE, HttpStatus.UNAUTHORIZED);
    }
}
