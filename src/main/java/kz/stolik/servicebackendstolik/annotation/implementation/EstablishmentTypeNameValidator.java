package kz.stolik.servicebackendstolik.annotation.implementation;

import kz.stolik.servicebackendstolik.annotation.annotation.EstablishmentTypeName;
import kz.stolik.servicebackendstolik.service.EstablishmentTypeService;
import kz.stolik.servicebackendstolik.service.impl.EstablishmentTypeServiceImpl;
import kz.stolik.servicebackendstolik.utils.HttpServletUtils;
import kz.stolik.servicebackendstolik.utils.ValidationUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static kz.stolik.servicebackendstolik.constants.base.EstablishmentTypeBaseConstants.*;
import static kz.stolik.servicebackendstolik.constants.validation.EstablishmentTypeValidationConstants.FIELD_NAME_RU_REQUIRED_MESSAGE;
import static kz.stolik.servicebackendstolik.constants.validation.EstablishmentTypeValidationConstants.FIELD_NAME_KK_REQUIRED_MESSAGE;
import static kz.stolik.servicebackendstolik.constants.validation.EstablishmentTypeValidationConstants.FIELD_NAME_EN_REQUIRED_MESSAGE;
import static kz.stolik.servicebackendstolik.constants.validation.BaseValidationConstants.FIELD_REQUIRED_MESSAGE;

public class EstablishmentTypeNameValidator implements ConstraintValidator<EstablishmentTypeName, String> {
    private final EstablishmentTypeService establishmentTypeService;

    private String field;
    private boolean required;


    public EstablishmentTypeNameValidator(EstablishmentTypeServiceImpl establishmentTypeService) {
        this.establishmentTypeService = establishmentTypeService;
    }

    @Override
    public void initialize(EstablishmentTypeName constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s != null && !s.isEmpty()) {
            if (HttpServletUtils.getPathVariable(ESTABLISHMENT_TYPE_ID_PATH_VARIABLE) != null)
                return !establishmentTypeService.existsByNameAndIdNot(s, getId(), field);
            return !establishmentTypeService.existsByName(s, field);
        } else {
            if (required)
                return ValidationUtils.setAnotherValidationErrorMessage(constraintValidatorContext, getFieldRequiredMessage());
            return true;
        }
    }


    public Long getId() {
        return Long.valueOf((String) HttpServletUtils.getPathVariable(ESTABLISHMENT_TYPE_ID_PATH_VARIABLE));
    }

    public String getFieldRequiredMessage() {
        switch (field){
            case FIELD_NAME_RU:
                return FIELD_NAME_RU_REQUIRED_MESSAGE;
            case FIELD_NAME_KK:
                return FIELD_NAME_KK_REQUIRED_MESSAGE;
            case FIELD_NAME_EN:
                return FIELD_NAME_EN_REQUIRED_MESSAGE;
        }
        return FIELD_REQUIRED_MESSAGE;
    }
}
