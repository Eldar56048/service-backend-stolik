package kz.stolik.servicebackendstolik.exception.domain;

import kz.stolik.servicebackendstolik.exception.CustomException;
import org.springframework.http.HttpStatus;

import static kz.stolik.servicebackendstolik.constants.exception.IngredientExceptionConstants.INGREDIENT_NOT_FOUND_BY_ID_CODE;
import static kz.stolik.servicebackendstolik.constants.exception.IngredientExceptionConstants.INGREDIENT_NOT_FOUND_BY_ID_MESSAGE;

public class IngredientNotFoundByIdException extends CustomException {
    public IngredientNotFoundByIdException() {
        super(INGREDIENT_NOT_FOUND_BY_ID_MESSAGE, INGREDIENT_NOT_FOUND_BY_ID_CODE, HttpStatus.NOT_FOUND);
    }
}
