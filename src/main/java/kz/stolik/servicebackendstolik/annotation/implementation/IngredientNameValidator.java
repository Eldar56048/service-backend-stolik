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
import static kz.stolik.servicebackendstolik.constants.validation.IngredientValidationConstants.FIELD_NAME_EN_REQUIRED_MESSAGE;
import static kz.stolik.servicebackendstolik.constants.validation.BaseValidationConstants.FIELD_REQUIRED_MESSAGE;

public class IngredientNameValidator implements ConstraintValidator<IngredientName, String> {
    private final IngredientService ingredientService;

    private String field;
    private boolean required;


    public IngredientNameValidator(IngredientServiceImpl ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Override
    public void initialize(IngredientName constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s != null && !s.isEmpty()) {
            if (HttpServletUtils.getPathVariable(INGREDIENT_ID_PATH_VARIABLE) != null)
                return !ingredientService.existsByNameAndIdNot(s, getId(), field);
            return !ingredientService.existsByName(s, field);
        } else {
            if (required)
                return ValidationUtils.setAnotherValidationErrorMessage(constraintValidatorContext, getFieldRequiredMessage());
            return true;
        }
    }

    public Long getId() {
        return Long.valueOf((String) HttpServletUtils.getPathVariable(INGREDIENT_ID_PATH_VARIABLE));
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
