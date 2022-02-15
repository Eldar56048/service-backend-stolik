package kz.stolik.servicebackendstolik.exception.domain;

import kz.stolik.servicebackendstolik.exception.CustomException;
import org.springframework.http.HttpStatus;

import static kz.stolik.servicebackendstolik.constants.exception.AuthExceptionConstants.*;

public class InvalidUsernameOrPasswordException extends CustomException {

    public InvalidUsernameOrPasswordException() {
        super(INVALID_USERNAME_OR_PASSWORD_MESSAGE, INVALID_USERNAME_OR_PASSWORD_CODE, HttpStatus.UNAUTHORIZED);
    }

}

