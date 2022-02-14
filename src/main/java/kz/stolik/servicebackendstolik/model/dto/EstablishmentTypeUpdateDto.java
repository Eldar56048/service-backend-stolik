package kz.stolik.servicebackendstolik.model.dto;

import lombok.Data;

@Data
public class EstablishmentTypeUpdateDto {
    private Long id;
    private String nameRu;
    private String nameKk;
    private String nameEn;
    private String description;
}
