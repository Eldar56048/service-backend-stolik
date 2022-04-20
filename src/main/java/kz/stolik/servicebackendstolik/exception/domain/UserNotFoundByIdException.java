package kz.stolik.servicebackendstolik.exception.domain;

import kz.stolik.servicebackendstolik.exception.CustomException;
import org.springframework.http.HttpStatus;

import static kz.stolik.servicebackendstolik.constants.exception.UserExceptionConstants.USER_NOT_FOUND_BY_ID_CODE;
import static kz.stolik.servicebackendstolik.constants.exception.UserExceptionConstants.USER_NOT_FOUND_BY_ID_MESSAGE;

public class UserNotFoundByIdException extends CustomException {
    public UserNotFoundByIdException() {
        super(USER_NOT_FOUND_BY_ID_MESSAGE, USER_NOT_FOUND_BY_ID_CODE, HttpStatus.NOT_FOUND);
    }
}
