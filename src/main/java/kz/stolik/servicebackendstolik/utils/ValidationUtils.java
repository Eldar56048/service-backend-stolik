package kz.stolik.servicebackendstolik.utils;

import javax.validation.ConstraintValidatorContext;

public class ValidationUtils {

    public static boolean setAnotherValidationErrorMessage(ConstraintValidatorContext context, String message) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation();
        return false;
    }

}
