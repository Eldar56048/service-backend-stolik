package kz.stolik.servicebackendstolik.annotation.annotation;

import kz.stolik.servicebackendstolik.annotation.implementation.IngredientNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static kz.stolik.servicebackendstolik.constants.validation.IngredientValidationConstants.INGREDIENT_NAME_ALREADY_EXISTS_MESSAGE;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IngredientNameValidator.class)
public @interface IngredientName {
    String message() default INGREDIENT_NAME_ALREADY_EXISTS_MESSAGE;
    String field();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
