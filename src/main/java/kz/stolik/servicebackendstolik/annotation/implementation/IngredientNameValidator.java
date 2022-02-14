package kz.stolik.servicebackendstolik.annotation.implementation;

import kz.stolik.servicebackendstolik.annotation.annotation.IngredientName;
import kz.stolik.servicebackendstolik.service.IngredientService;
import kz.stolik.servicebackendstolik.service.impl.IngredientServiceImpl;
import kz.stolik.servicebackendstolik.utils.HttpServletUtils;
import kz.stolik.servicebackendstolik.utils.ValidationUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static kz.stolik.servicebackendstolik.constants.base.IngredientBaseConstants.FIELD_NAME_KK;
import static kz.stolik.servicebackendstolik.constants.base.IngredientBaseConstants.FIELD_NAME_RU;
import static kz.stolik.servicebackendstolik.constants.base.IngredientBaseConstants.FIELD_NAME_EN;
import static kz.stolik.servicebackendstolik.constants.base.IngredientBaseConstants.INGREDIENT_ID_PATH_VARIABLE;
import static kz.stolik.servicebackendstolik.constants.validation.IngredientValidationConstants.FIELD_NAME_KK_REQUIRED_MESSAGE;
import static kz.stolik.servicebackendstolik.constants.validation.IngredientValidationConstants.FIELD_NAME_RU_REQUIRED_MESSAGE;

public class IngredientNameValidator implements ConstraintValidator<IngredientName, String> {
    private final IngredientService ingredientService;

    private String field;


    public IngredientNameValidator(IngredientServiceImpl ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Override
    public void initialize(IngredientName constraintAnnotation) {
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
        if (HttpServletUtils.getPathVariable(INGREDIENT_ID_PATH_VARIABLE) != null)
            return !ingredientService.existsByNameAndIdNot(nameRu, getId(), FIELD_NAME_RU);
        return !ingredientService.existsByName(nameRu, FIELD_NAME_RU);
    }

    public boolean isValidNameKk(String nameKk, ConstraintValidatorContext constraintValidatorContext) {
        if (nameKk == null || nameKk.equals(""))
            return ValidationUtils.setAnotherValidationErrorMessage(constraintValidatorContext, FIELD_NAME_KK_REQUIRED_MESSAGE);
        if (HttpServletUtils.getPathVariable(INGREDIENT_ID_PATH_VARIABLE) != null)
            return !ingredientService.existsByNameAndIdNot(nameKk, getId(), FIELD_NAME_KK);
        return !ingredientService.existsByName(nameKk, FIELD_NAME_KK);
    }

    public boolean isValidNameEn(String nameEn, ConstraintValidatorContext constraintValidatorContext) {
        if (nameEn == null || nameEn.equals(""))
            return true;
        else {
            if (HttpServletUtils.getPathVariable(INGREDIENT_ID_PATH_VARIABLE) != null) {
                return !ingredientService.existsByNameAndIdNot(nameEn, getId(), FIELD_NAME_EN);
            }
            return !ingredientService.existsByName(nameEn, FIELD_NAME_EN);
        }
    }

    public Long getId() {
        return Long.valueOf((String) HttpServletUtils.getPathVariable(INGREDIENT_ID_PATH_VARIABLE));
    }
}
