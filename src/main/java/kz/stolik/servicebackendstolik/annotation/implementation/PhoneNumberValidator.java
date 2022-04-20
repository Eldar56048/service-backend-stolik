package kz.stolik.servicebackendstolik.annotation.implementation;

import kz.stolik.servicebackendstolik.annotation.annotation.PhoneNumber;
import kz.stolik.servicebackendstolik.service.UserService;
import kz.stolik.servicebackendstolik.service.impl.UserServiceImpl;
import kz.stolik.servicebackendstolik.utils.HttpServletUtils;
import kz.stolik.servicebackendstolik.utils.ValidationUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static kz.stolik.servicebackendstolik.constants.base.UserBaseConstants.USER_ID_PATH_VARIABLE;
import static kz.stolik.servicebackendstolik.constants.validation.UserValidationConstants.USER_PHONE_NUMBER_INVALID_FORMAT_MESSAGE;
import static kz.stolik.servicebackendstolik.constants.validation.UserValidationConstants.USER_PHONE_NUMBER_REQUIRED_MESSAGE;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    private final UserService userService;

    private boolean required;


    public PhoneNumberValidator(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        this.required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s != null && !s.isEmpty()) {
            Pattern p = Pattern.compile("[0-9]{12}");
            Matcher m = p.matcher(s);
            if (!m.matches())
                return ValidationUtils.setAnotherValidationErrorMessage(constraintValidatorContext, USER_PHONE_NUMBER_INVALID_FORMAT_MESSAGE);

            if (HttpServletUtils.getPathVariable(USER_ID_PATH_VARIABLE) != null)
                return !userService.existsByPhoneNumberAndIdNot(s, getId());
            return !userService.existsByPhoneNumber(s);
        } else {
            if (required)
                return ValidationUtils.setAnotherValidationErrorMessage(constraintValidatorContext, USER_PHONE_NUMBER_REQUIRED_MESSAGE);
            return true;
        }
    }

    public Long getId() {
        return Long.valueOf((String) HttpServletUtils.getPathVariable(USER_ID_PATH_VARIABLE));
    }


}
