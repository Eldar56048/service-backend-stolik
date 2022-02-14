package kz.stolik.servicebackendstolik.service.impl;

import kz.stolik.servicebackendstolik.model.dto.IngredientCreateDto;
import kz.stolik.servicebackendstolik.model.dto.IngredientUpdateDto;
import kz.stolik.servicebackendstolik.model.dto.SearchCriteriaDto;
import kz.stolik.servicebackendstolik.model.entity.Ingredient;
import kz.stolik.servicebackendstolik.model.repository.IngredientRepository;
import kz.stolik.servicebackendstolik.service.IngredientService;
import kz.stolik.servicebackendstolik.specification.base.BaseSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static kz.stolik.servicebackendstolik.constants.base.IngredientBaseConstants.FIELD_NAME_RU;
import static kz.stolik.servicebackendstolik.constants.base.IngredientBaseConstants.FIELD_NAME_EN;
import static kz.stolik.servicebackendstolik.constants.base.IngredientBaseConstants.FIELD_NAME_KK;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;
    private final ModelMapper modelMapper;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
        this.modelMapper = new ModelMapper();
    }


    @Override
    public Page<Ingredient> getAll(Pageable pageable) {
        return ingredientRepository.findAll(pageable);
    }

    @Override
    public Page<Ingredient> searchWithFilter(List<SearchCriteriaDto> criteria, Pageable pageable) {
        return ingredientRepository.findAll(new BaseSpecification<Ingredient>(criteria, Ingredient.class), pageable);
    }

    @Override
    public Ingredient create(IngredientCreateDto ingredientCreateDto) {
        return save(modelMapper.map(ingredientCreateDto, Ingredient.class));
    }

    @Override
    public Ingredient getById(Long id) {
        return ingredientRepository.findById(id).orElse(null);
    }

    @Override
    public Ingredient update(IngredientUpdateDto ingredientUpdateDto) {
        Ingredient ingredient = getById(ingredientUpdateDto.getId());
        modelMapper.map(ingredientUpdateDto, Ingredient.class);
        return save(ingredient);
    }

    @Override
    public Ingredient save(Ingredient model) {
        return ingredientRepository.save(model);
    }

    @Override
    public boolean existsById(Long id) {
        return ingredientRepository.existsById(id);
    }

    @Override
    public boolean existsByName(String name, String localName) {
        switch (localName) {
            case FIELD_NAME_EN:
                return ingredientRepository.existsByNameEn(name);
            case FIELD_NAME_RU:
                return ingredientRepository.existsByNameRu(name);
            case FIELD_NAME_KK:
                return ingredientRepository.existsByNameKk(name);
        }
        return false;
    }

    @Override
    public boolean existsByNameAndIdNot(String name, Long id, String localName) {
        switch (localName) {
            case FIELD_NAME_EN:
                return ingredientRepository.existsByNameEnAndIdNot(name, id);
            case FIELD_NAME_RU:
                return ingredientRepository.existsByNameRuAndIdNot(name, id);
            case FIELD_NAME_KK:
                return ingredientRepository.existsByNameKkAndIdNot(name, id);
        }
        return false;
    }
}
