package kz.stolik.servicebackendstolik.exception.domain;

import kz.stolik.servicebackendstolik.exception.CustomException;
import org.springframework.http.HttpStatus;

import static kz.stolik.servicebackendstolik.constants.exception.AuthExceptionConstants.FETCH_USERNAME_FROM_TOKEN_ERROR_MESSAGE;
import static kz.stolik.servicebackendstolik.constants.exception.AuthExceptionConstants.FETCH_USERNAME_FROM_TOKEN_ERROR_CODE;

public class FetchUsernameFromTokenException extends CustomException {
    public FetchUsernameFromTokenException() {
        super(FETCH_USERNAME_FROM_TOKEN_ERROR_MESSAGE, FETCH_USERNAME_FROM_TOKEN_ERROR_CODE, HttpStatus.UNAUTHORIZED);
    }
}
