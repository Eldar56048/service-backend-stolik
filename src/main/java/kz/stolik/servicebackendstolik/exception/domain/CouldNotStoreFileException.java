package kz.stolik.servicebackendstolik.exception.domain;

import kz.stolik.servicebackendstolik.exception.CustomException;
import org.springframework.http.HttpStatus;

import static kz.stolik.servicebackendstolik.constants.exception.FileStorageExceptionConstants.COULD_NOT_STORE_FILE_TRY_AGAIN_MESSAGE;
import static kz.stolik.servicebackendstolik.constants.exception.FileStorageExceptionConstants.COULD_NOT_STORE_FILE_TRY_AGAIN_CODE;

public class CouldNotStoreFileException extends CustomException {
    public CouldNotStoreFileException() {
        super(COULD_NOT_STORE_FILE_TRY_AGAIN_MESSAGE, COULD_NOT_STORE_FILE_TRY_AGAIN_CODE, HttpStatus.CONFLICT);
    }
}
