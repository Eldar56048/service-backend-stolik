package kz.stolik.servicebackendstolik.exception.domain;

import kz.stolik.servicebackendstolik.exception.CustomException;
import org.springframework.http.HttpStatus;

import static kz.stolik.servicebackendstolik.constants.exception.AuthExceptionConstants.INVALID_TOKEN_MESSAGE;
import static kz.stolik.servicebackendstolik.constants.exception.AuthExceptionConstants.INVALID_TOKEN_CODE;

public class InvalidTokenFormatException extends CustomException {
    public InvalidTokenFormatException() {
        super(INVALID_TOKEN_MESSAGE, INVALID_TOKEN_CODE, HttpStatus.UNAUTHORIZED);
    }
}
