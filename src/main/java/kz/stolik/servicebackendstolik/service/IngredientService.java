package kz.stolik.servicebackendstolik.service;

import kz.stolik.servicebackendstolik.model.dto.IngredientCreateDto;
import kz.stolik.servicebackendstolik.model.dto.IngredientUpdateDto;
import kz.stolik.servicebackendstolik.model.entity.Ingredient;
import kz.stolik.servicebackendstolik.service.base.CrudService;

public interface IngredientService extends CrudService<Ingredient, IngredientCreateDto, IngredientUpdateDto> {
    boolean existsByName(String name, String localName);
    boolean existsByNameAndIdNot(String name, Long id, String localName);

}
