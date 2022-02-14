package kz.stolik.servicebackendstolik.service;

import kz.stolik.servicebackendstolik.model.dto.EstablishmentTypeCreateDto;
import kz.stolik.servicebackendstolik.model.dto.EstablishmentTypeUpdateDto;
import kz.stolik.servicebackendstolik.model.entity.EstablishmentType;
import kz.stolik.servicebackendstolik.service.base.CrudService;

public interface EstablishmentTypeService extends CrudService<EstablishmentType, EstablishmentTypeCreateDto, EstablishmentTypeUpdateDto> {
    boolean existsByName(String name, String localName);
    boolean existsByNameAndIdNot(String name, Long id, String localName);
}
