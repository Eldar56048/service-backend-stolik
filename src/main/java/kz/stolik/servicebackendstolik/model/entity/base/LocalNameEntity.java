package kz.stolik.servicebackendstolik.model.entity.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class LocalNameEntity extends BaseEntity{
    private String nameRu;
    @ApiModelProperty(value = "Наименование ингредиента на каз", name = "nameKk", dataType = "String", example = "Тұз")
    private String nameKk;
    @ApiModelProperty(value = "Наименование ингредиента на англ", name = "nameEn", dataType = "String", example = "Salt")
    private String nameEn;
}
