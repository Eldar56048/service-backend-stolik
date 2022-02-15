package kz.stolik.servicebackendstolik.exception.domain;

import kz.stolik.servicebackendstolik.exception.CustomException;
import org.springframework.http.HttpStatus;

import static kz.stolik.servicebackendstolik.constants.exception.FileStorageExceptionConstants.FILE_NOT_FOUND_MESSAGE;
import static kz.stolik.servicebackendstolik.constants.exception.FileStorageExceptionConstants.FILE_NOT_FOUND_CODE;

public class FileNotFoundException extends CustomException {
    public FileNotFoundException() {
        super(FILE_NOT_FOUND_MESSAGE, FILE_NOT_FOUND_CODE, HttpStatus.NOT_FOUND);
    }
}
