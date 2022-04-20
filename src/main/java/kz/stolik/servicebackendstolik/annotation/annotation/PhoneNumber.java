package kz.stolik.servicebackendstolik.annotation.annotation;

import kz.stolik.servicebackendstolik.annotation.implementation.PhoneNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static kz.stolik.servicebackendstolik.constants.validation.UserValidationConstants.USER_PHONE_NUMBER_ALREADY_EXISTS_MESSAGE;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface PhoneNumber {
    String message() default USER_PHONE_NUMBER_ALREADY_EXISTS_MESSAGE;
    boolean required() default false;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
