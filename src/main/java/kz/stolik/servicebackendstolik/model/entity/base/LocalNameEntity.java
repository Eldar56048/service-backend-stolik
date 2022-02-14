package kz.stolik.servicebackendstolik.model.entity.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

import static kz.stolik.servicebackendstolik.constants.swagger.LocalNameEntitySwaggerConstants.NAME_RU_DESCRIPTION;
import static kz.stolik.servicebackendstolik.constants.swagger.LocalNameEntitySwaggerConstants.NAME_RU_EXAMPLE;

import static kz.stolik.servicebackendstolik.constants.swagger.LocalNameEntitySwaggerConstants.NAME_KK_EXAMPLE;
import static kz.stolik.servicebackendstolik.constants.swagger.LocalNameEntitySwaggerConstants.NAME_KK_DESCRIPTION;

import static kz.stolik.servicebackendstolik.constants.swagger.LocalNameEntitySwaggerConstants.NAME_EN_DESCRIPTION;
import static kz.stolik.servicebackendstolik.constants.swagger.LocalNameEntitySwaggerConstants.NAME_EN_EXAMPLE;

@MappedSuperclass
@Getter
@Setter
public class LocalNameEntity extends BaseEntity{
    @Schema(description = NAME_RU_DESCRIPTION, example = NAME_RU_EXAMPLE, required = true)
    private String nameRu;
    @Schema(description = NAME_KK_DESCRIPTION, example = NAME_KK_EXAMPLE, required = true)
    private String nameKk;
    @Schema(description = NAME_EN_DESCRIPTION, example = NAME_EN_EXAMPLE)
    private String nameEn;
}
