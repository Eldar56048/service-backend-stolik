package kz.stolik.servicebackendstolik.exception.domain;

import kz.stolik.servicebackendstolik.exception.CustomException;
import org.springframework.http.HttpStatus;

import static kz.stolik.servicebackendstolik.constants.exception.AuthExceptionConstants.ACCOUNT_BLOCKED_MESSAGE;
import static kz.stolik.servicebackendstolik.constants.exception.AuthExceptionConstants.ACCOUNT_BLOCKED_CODE;

public class AccountBlockedException extends CustomException {
    public AccountBlockedException() {
        super(ACCOUNT_BLOCKED_MESSAGE, ACCOUNT_BLOCKED_CODE, HttpStatus.FORBIDDEN);
    }
}
