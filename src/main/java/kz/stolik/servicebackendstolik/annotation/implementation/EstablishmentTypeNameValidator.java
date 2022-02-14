package kz.stolik.servicebackendstolik.annotation.implementation;

import kz.stolik.servicebackendstolik.annotation.annotation.EstablishmentTypeName;
import kz.stolik.servicebackendstolik.annotation.annotation.IngredientName;
import kz.stolik.servicebackendstolik.service.EstablishmentTypeService;
import kz.stolik.servicebackendstolik.service.IngredientService;
import kz.stolik.servicebackendstolik.service.impl.EstablishmentTypeServiceImpl;
import kz.stolik.servicebackendstolik.service.impl.IngredientServiceImpl;
import kz.stolik.servicebackendstolik.utils.HttpServletUtils;
import kz.stolik.servicebackendstolik.utils.ValidationUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static kz.stolik.servicebackendstolik.constants.base.EstablishmentTypeBaseConstants.*;
import static kz.stolik.servicebackendstolik.constants.validation.IngredientValidationConstants.FIELD_NAME_KK_REQUIRED_MESSAGE;
import static kz.stolik.servicebackendstolik.constants.validation.IngredientValidationConstants.FIELD_NAME_RU_REQUIRED_MESSAGE;

public class EstablishmentTypeNameValidator implements ConstraintValidator<EstablishmentTypeName, String> {
    private final EstablishmentTypeService establishmentTypeService;

    private String field;


    public EstablishmentTypeNameValidator(EstablishmentTypeServiceImpl establishmentTypeService) {
        this.establishmentTypeService = establishmentTypeService;
    }

    @Override
    public void initialize(EstablishmentTypeName constraintAnnotation) {
        this.field = constraintAnnotation.field();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (field.equals(FIELD_NAME_RU))
            return isValidNameRu(s, constraintValidatorContext);
        else if (field.equals(FIELD_NAME_KK))
            return isValidNameKk(s, constraintValidatorContext);
        return isValidNameEn(s, constraintValidatorContext);
    }

    public boolean isValidNameRu(String nameRu, ConstraintValidatorContext constraintValidatorContext) {
        if (nameRu == null || nameRu.equals(""))
            return ValidationUtils.setAnotherValidationErrorMessage(constraintValidatorContext, FIELD_NAME_RU_REQUIRED_MESSAGE);
        if (HttpServletUtils.getPathVariable(ESTABLISHMENT_TYPE_ID_PATH_VARIABLE) != null)
            return !establishmentTypeService.existsByNameAndIdNot(nameRu, getId(), FIELD_NAME_RU);
        return !establishmentTypeService.existsByName(nameRu, FIELD_NAME_RU);
    }

    public boolean isValidNameKk(String nameKk, ConstraintValidatorContext constraintValidatorContext) {
        if (nameKk == null || nameKk.equals(""))
            return ValidationUtils.setAnotherValidationErrorMessage(constraintValidatorContext, FIELD_NAME_KK_REQUIRED_MESSAGE);
        if (HttpServletUtils.getPathVariable(ESTABLISHMENT_TYPE_ID_PATH_VARIABLE) != null)
            return !establishmentTypeService.existsByNameAndIdNot(nameKk, getId(), FIELD_NAME_KK);
        return !establishmentTypeService.existsByName(nameKk, FIELD_NAME_KK);
    }

    public boolean isValidNameEn(String nameEn, ConstraintValidatorContext constraintValidatorContext) {
        if (nameEn == null || nameEn.equals(""))
            return true;
        else {
            if (HttpServletUtils.getPathVariable(ESTABLISHMENT_TYPE_ID_PATH_VARIABLE) != null) {
                return !establishmentTypeService.existsByNameAndIdNot(nameEn, getId(), FIELD_NAME_EN);
            }
            return !establishmentTypeService.existsByName(nameEn, FIELD_NAME_EN);
        }
    }

    public Long getId() {
        return Long.valueOf((String) HttpServletUtils.getPathVariable(ESTABLISHMENT_TYPE_ID_PATH_VARIABLE));
    }
}
