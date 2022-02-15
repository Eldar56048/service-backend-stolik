package kz.stolik.servicebackendstolik.annotation.annotation;

import kz.stolik.servicebackendstolik.annotation.implementation.EstablishmentTypeNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static kz.stolik.servicebackendstolik.constants.validation.EstablishmentTypeValidationConstants.ESTABLISHMENT_TYPE_NAME_ALREADY_EXISTS_MESSAGE;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EstablishmentTypeNameValidator.class)
public @interface EstablishmentTypeName {
    String message() default ESTABLISHMENT_TYPE_NAME_ALREADY_EXISTS_MESSAGE;
    String field();
    boolean required() default false;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
