package kz.stolik.servicebackendstolik.exception.domain;

import kz.stolik.servicebackendstolik.exception.Exception;
import org.springframework.http.HttpStatus;

import static kz.stolik.servicebackendstolik.constants.exception.IngredientExceptionConstants.INGREDIENT_NOT_FOUND_BY_ID_CODE;
import static kz.stolik.servicebackendstolik.constants.exception.IngredientExceptionConstants.INGREDIENT_NOT_FOUND_BY_ID_MESSAGE;

public class IngredientNotFoundException extends Exception {
    public IngredientNotFoundException() {
        super(INGREDIENT_NOT_FOUND_BY_ID_MESSAGE, INGREDIENT_NOT_FOUND_BY_ID_CODE, HttpStatus.NOT_FOUND);
    }
}
