package kz.stolik.servicebackendstolik.exception.domain;

import kz.stolik.servicebackendstolik.exception.CustomException;
import org.springframework.http.HttpStatus;

import static kz.stolik.servicebackendstolik.constants.exception.EstablishmentTypeExceptionConstants.ESTABLISHMENT_TYPE_NOT_FOUND_BY_ID_CODE;
import static kz.stolik.servicebackendstolik.constants.exception.EstablishmentTypeExceptionConstants.ESTABLISHMENT_TYPE_NOT_FOUND_BY_ID_MESSAGE;

public class EstablishmentTypeNotFoundByIdException extends CustomException {
    public EstablishmentTypeNotFoundByIdException() {
        super(ESTABLISHMENT_TYPE_NOT_FOUND_BY_ID_MESSAGE, ESTABLISHMENT_TYPE_NOT_FOUND_BY_ID_CODE, HttpStatus.NOT_FOUND);
    }
}
