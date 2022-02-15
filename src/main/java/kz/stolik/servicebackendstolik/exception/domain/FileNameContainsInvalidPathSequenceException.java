package kz.stolik.servicebackendstolik.exception.domain;

import kz.stolik.servicebackendstolik.exception.CustomException;
import org.springframework.http.HttpStatus;

import static kz.stolik.servicebackendstolik.constants.exception.FileStorageExceptionConstants.FILE_NAME_CONTAINS_INVALID_PATH_SEQUENCE_MESSAGE;
import static kz.stolik.servicebackendstolik.constants.exception.FileStorageExceptionConstants.FILE_NAME_CONTAINS_INVALID_PATH_SEQUENCE_CODE;

public class FileNameContainsInvalidPathSequenceException extends CustomException {
    public FileNameContainsInvalidPathSequenceException() {
        super(FILE_NAME_CONTAINS_INVALID_PATH_SEQUENCE_MESSAGE, FILE_NAME_CONTAINS_INVALID_PATH_SEQUENCE_CODE, HttpStatus.BAD_REQUEST);
    }
}
