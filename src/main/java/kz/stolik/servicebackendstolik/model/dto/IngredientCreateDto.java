package kz.stolik.servicebackendstolik.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import kz.stolik.servicebackendstolik.annotation.annotation.IngredientName;
import lombok.Getter;
import lombok.Setter;

import static kz.stolik.servicebackendstolik.constants.base.IngredientBaseConstants.FIELD_NAME_EN;
import static kz.stolik.servicebackendstolik.constants.base.IngredientBaseConstants.FIELD_NAME_RU;
import static kz.stolik.servicebackendstolik.constants.base.IngredientBaseConstants.FIELD_NAME_KK;

import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.FIELD_NAME_RU_DESCRIPTION;
import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.FIELD_NAME_RU_EXAMPLE;
import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.FIELD_NAME_KK_DESCRIPTION;
import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.FIELD_NAME_KK_EXAMPLE;
import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.FIELD_NAME_EN_DESCRIPTION;
import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.FIELD_NAME_EN_EXAMPLE;
import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.INGREDIENT_CREATE_DTO_TITLE;

@Getter
@Setter
@Schema(title = INGREDIENT_CREATE_DTO_TITLE)
public class IngredientCreateDto {

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
