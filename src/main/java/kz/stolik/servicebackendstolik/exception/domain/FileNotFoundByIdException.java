package kz.stolik.servicebackendstolik.exception.domain;

import kz.stolik.servicebackendstolik.exception.CustomException;
import org.springframework.http.HttpStatus;

import static kz.stolik.servicebackendstolik.constants.exception.FileStorageExceptionConstants.FILE_NOT_FOUND_BY_ID_MESSAGE;
import static kz.stolik.servicebackendstolik.constants.exception.FileStorageExceptionConstants.FILE_NOT_FOUND_BY_ID_CODE;

public class FileNotFoundByIdException extends CustomException {
    public FileNotFoundByIdException() {
        super(FILE_NOT_FOUND_BY_ID_MESSAGE, FILE_NOT_FOUND_BY_ID_CODE, HttpStatus.NOT_FOUND);
    }
}
