package kz.stolik.servicebackendstolik.exception.domain;

import kz.stolik.servicebackendstolik.exception.CustomException;
import org.springframework.http.HttpStatus;

import static kz.stolik.servicebackendstolik.constants.exception.AuthExceptionConstants.TOKEN_NOT_FOUND_MESSAGE;
import static kz.stolik.servicebackendstolik.constants.exception.AuthExceptionConstants.TOKEN_NOT_FOUND_CODE;

public class TokenNotFoundException extends CustomException {
    public TokenNotFoundException() {
        super(TOKEN_NOT_FOUND_MESSAGE, TOKEN_NOT_FOUND_CODE, HttpStatus.UNAUTHORIZED);
    }
}
