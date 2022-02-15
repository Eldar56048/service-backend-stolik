package kz.stolik.servicebackendstolik.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import kz.stolik.servicebackendstolik.annotation.annotation.IngredientName;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import static kz.stolik.servicebackendstolik.constants.base.IngredientBaseConstants.*;

import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.FIELD_NAME_RU_DESCRIPTION;
import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.FIELD_NAME_RU_EXAMPLE;
import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.FIELD_NAME_KK_DESCRIPTION;
import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.FIELD_NAME_KK_EXAMPLE;
import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.FIELD_NAME_EN_DESCRIPTION;
import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.FIELD_NAME_EN_EXAMPLE;
import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.INGREDIENT_UPDATE_DTO_TITLE;
import static kz.stolik.servicebackendstolik.constants.validation.IngredientValidationConstants.FIELD_ID_REQUIRED_MESSAGE;
import static kz.stolik.servicebackendstolik.constants.validation.IngredientValidationConstants.FIELD_ID_VALUE_SHOULD_BE_POSITIVE_MESSAGE;
import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.FIELD_ID_DESCRIPTION;
import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.FIELD_ID_EXAMPLE;

@Getter
@Setter
@Schema(title = INGREDIENT_UPDATE_DTO_TITLE)
public class IngredientUpdateDto {

    @NotNull(message = FIELD_ID_REQUIRED_MESSAGE)
    @Positive(message = FIELD_ID_VALUE_SHOULD_BE_POSITIVE_MESSAGE)
    @Schema(description = FIELD_ID_DESCRIPTION, example = FIELD_ID_EXAMPLE, required = true)
    private Long id;

    @IngredientName(field = FIELD_NAME_RU, required = true)
    @Schema(description = FIELD_NAME_RU_DESCRIPTION, example = FIELD_NAME_RU_EXAMPLE, required = true)
    private String nameRu;

    @IngredientName(field = FIELD_NAME_KK)
    @Schema(description = FIELD_NAME_KK_DESCRIPTION, example = FIELD_NAME_KK_EXAMPLE, nullable = true)
    private String nameKk;

    @IngredientName(field = FIELD_NAME_EN)
    @Schema(description = FIELD_NAME_EN_DESCRIPTION, example = FIELD_NAME_EN_EXAMPLE, nullable = true)
    private String nameEn;

}
