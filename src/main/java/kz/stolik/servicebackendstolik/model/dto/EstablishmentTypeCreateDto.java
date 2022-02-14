package kz.stolik.servicebackendstolik.model.dto;

import lombok.Data;

@Data
public class EstablishmentTypeCreateDto {
    private String nameRu;
    private String nameKk;
    private String nameEn;
    private String description;
}
