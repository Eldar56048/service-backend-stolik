package kz.stolik.servicebackendstolik.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import kz.stolik.servicebackendstolik.annotation.annotation.EstablishmentTypeName;
import lombok.Data;

import static kz.stolik.servicebackendstolik.constants.base.EstablishmentTypeBaseConstants.FIELD_NAME_RU;
import static kz.stolik.servicebackendstolik.constants.base.EstablishmentTypeBaseConstants.FIELD_NAME_KK;
import static kz.stolik.servicebackendstolik.constants.base.EstablishmentTypeBaseConstants.FIELD_NAME_EN;
import static kz.stolik.servicebackendstolik.constants.swagger.EstablishmentTypeSwaggerConstants.FIELD_NAME_RU_DESCRIPTION;
import static kz.stolik.servicebackendstolik.constants.swagger.EstablishmentTypeSwaggerConstants.FIELD_NAME_RU_EXAMPLE;
import static kz.stolik.servicebackendstolik.constants.swagger.EstablishmentTypeSwaggerConstants.FIELD_NAME_KK_DESCRIPTION;
import static kz.stolik.servicebackendstolik.constants.swagger.EstablishmentTypeSwaggerConstants.FIELD_NAME_KK_EXAMPLE;
import static kz.stolik.servicebackendstolik.constants.swagger.EstablishmentTypeSwaggerConstants.FIELD_NAME_EN_DESCRIPTION;
import static kz.stolik.servicebackendstolik.constants.swagger.EstablishmentTypeSwaggerConstants.FIELD_NAME_EN_EXAMPLE;
import static kz.stolik.servicebackendstolik.constants.swagger.EstablishmentTypeSwaggerConstants.DESCRIPTION_FIELD_EXAMPLE;
import static kz.stolik.servicebackendstolik.constants.swagger.EstablishmentTypeSwaggerConstants.DESCRIPTION_FIELD_DESCRIPTION;
import static kz.stolik.servicebackendstolik.constants.swagger.EstablishmentTypeSwaggerConstants.ESTABLISHMENT_TYPE_CREATE_DTO_TITLE;

@Data
@Schema(title = ESTABLISHMENT_TYPE_CREATE_DTO_TITLE)
public class EstablishmentTypeCreateDto {

    @EstablishmentTypeName(field = FIELD_NAME_RU)
    @Schema(description = FIELD_NAME_RU_DESCRIPTION, example = FIELD_NAME_RU_EXAMPLE, required = true)
    private String nameRu;

    @EstablishmentTypeName(field = FIELD_NAME_KK)
    @Schema(description = FIELD_NAME_KK_DESCRIPTION, example = FIELD_NAME_KK_EXAMPLE, required = true)
    private String nameKk;

    @EstablishmentTypeName(field = FIELD_NAME_EN)
    @Schema(description = FIELD_NAME_EN_DESCRIPTION, example = FIELD_NAME_EN_EXAMPLE, required = true)
    private String nameEn;

    @Schema(description = DESCRIPTION_FIELD_DESCRIPTION, example = DESCRIPTION_FIELD_EXAMPLE)
    private String description;

}
