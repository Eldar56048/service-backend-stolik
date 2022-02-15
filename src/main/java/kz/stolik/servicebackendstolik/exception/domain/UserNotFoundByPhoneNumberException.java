package kz.stolik.servicebackendstolik.exception.domain;

import kz.stolik.servicebackendstolik.exception.CustomException;
import org.springframework.http.HttpStatus;

import static kz.stolik.servicebackendstolik.constants.exception.UserExceptionConstants.USER_NOT_FOUND_BY_PHONE_NUMBER_MESSAGE;
import static kz.stolik.servicebackendstolik.constants.exception.UserExceptionConstants.USER_NOT_FOUND_BY_PHONE_NUMBER_CODE;

public class UserNotFoundByPhoneNumberException extends CustomException {
    public UserNotFoundByPhoneNumberException() {
        super(USER_NOT_FOUND_BY_PHONE_NUMBER_MESSAGE, USER_NOT_FOUND_BY_PHONE_NUMBER_CODE, HttpStatus.NOT_FOUND);
    }
}
