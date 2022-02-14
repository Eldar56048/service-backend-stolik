package kz.stolik.servicebackendstolik.exception.domain;

import kz.stolik.servicebackendstolik.exception.Exception;
import org.springframework.http.HttpStatus;

import static kz.stolik.servicebackendstolik.constants.exception.BaseExceptionConstants.BODY_OBJECT_ID_DOES_NOT_MATCH_REQUEST_ID_MESSAGE;
import static kz.stolik.servicebackendstolik.constants.exception.BaseExceptionConstants.BODY_OBJECT_ID_DOES_NOT_MATCH_REQUEST_ID_CODE;

public class BodyObjectIdDoesNotMatchRequestIdException extends Exception
{
    public BodyObjectIdDoesNotMatchRequestIdException() {
        super(BODY_OBJECT_ID_DOES_NOT_MATCH_REQUEST_ID_MESSAGE, BODY_OBJECT_ID_DOES_NOT_MATCH_REQUEST_ID_CODE, HttpStatus.BAD_REQUEST);
    }
}
