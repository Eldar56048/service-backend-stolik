package kz.stolik.servicebackendstolik.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import kz.stolik.servicebackendstolik.annotation.annotation.IngredientName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import static kz.stolik.servicebackendstolik.constants.base.IngredientBaseConstants.*;

import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.NAME_RU_DESCRIPTION;
import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.NAME_RU_EXAMPLE;
import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.NAME_KK_DESCRIPTION;
import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.NAME_KK_EXAMPLE;
import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.NAME_EN_DESCRIPTION;
import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.NAME_EN_EXAMPLE;
import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.INGREDIENT_UPDATE_DTO_DESCRIPTION;


@Getter
@Setter
@Schema(description = INGREDIENT_UPDATE_DTO_DESCRIPTION)
public class IngredientUpdateDto {
    @NotNull
    @Positive
    private Long id;
    @IngredientName(field = FIELD_NAME_RU)
    @Schema(description = NAME_RU_DESCRIPTION, example = NAME_RU_EXAMPLE, required = true)
    private String nameRu;
    @IngredientName(field = FIELD_NAME_KK)
    @Schema(description = NAME_KK_DESCRIPTION, example = NAME_KK_EXAMPLE, nullable = true)
    private String nameKk;
    @IngredientName(field = FIELD_NAME_EN)
    @Schema(description = NAME_EN_DESCRIPTION, example = NAME_EN_EXAMPLE, nullable = true)
    private String nameEn;
}
