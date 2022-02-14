package kz.stolik.servicebackendstolik.service.impl;

import kz.stolik.servicebackendstolik.constants.base.IngredientBaseConstants;
import kz.stolik.servicebackendstolik.model.dto.EstablishmentTypeCreateDto;
import kz.stolik.servicebackendstolik.model.dto.EstablishmentTypeUpdateDto;
import kz.stolik.servicebackendstolik.model.dto.SearchCriteriaDto;
import kz.stolik.servicebackendstolik.model.entity.EstablishmentType;
import kz.stolik.servicebackendstolik.model.repository.EstablishmentTypeRepository;
import kz.stolik.servicebackendstolik.service.EstablishmentTypeService;
import kz.stolik.servicebackendstolik.specification.base.BaseSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static kz.stolik.servicebackendstolik.constants.base.EstablishmentTypeBaseConstants.FIELD_NAME_RU;
import static kz.stolik.servicebackendstolik.constants.base.EstablishmentTypeBaseConstants.FIELD_NAME_KK;
import static kz.stolik.servicebackendstolik.constants.base.EstablishmentTypeBaseConstants.FIELD_NAME_EN;

@Service
public class EstablishmentTypeServiceImpl implements EstablishmentTypeService {
    private final EstablishmentTypeRepository establishmentTypeRepository;
    private final ModelMapper modelMapper;

    public EstablishmentTypeServiceImpl(EstablishmentTypeRepository establishmentTypeRepository) {
        this.establishmentTypeRepository = establishmentTypeRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Page<EstablishmentType> getAll(Pageable pageable) {
        return establishmentTypeRepository.findAll(pageable);
    }

    @Override
    public Page<EstablishmentType> searchWithFilter(List<SearchCriteriaDto> criteria, Pageable pageable) {
        return establishmentTypeRepository.findAll(new BaseSpecification<>(criteria, EstablishmentType.class), pageable);
    }

    @Override
    public EstablishmentType create(EstablishmentTypeCreateDto establishmentTypeCreateDto) {
        return null;
    }

    @Override
    public EstablishmentType getById(Long id) {
        return establishmentTypeRepository.findById(id).orElse(null);
    }

    @Override
    public EstablishmentType update(EstablishmentTypeUpdateDto establishmentTypeUpdateDto) {
        return null;
    }

    @Override
    public EstablishmentType save(EstablishmentType model) {
        return establishmentTypeRepository.save(model);
    }

    @Override
    public boolean existsById(Long id) {
        return establishmentTypeRepository.existsById(id);
    }

    @Override
    public boolean existsByName(String name, String localName) {
        switch (localName) {
            case IngredientBaseConstants.FIELD_NAME_EN:
                return establishmentTypeRepository.existsByNameEn(name);
            case IngredientBaseConstants.FIELD_NAME_RU:
                return establishmentTypeRepository.existsByNameRu(name);
            case IngredientBaseConstants.FIELD_NAME_KK:
                return establishmentTypeRepository.existsByNameKk(name);
        }
        return false;
    }

    @Override
    public boolean existsByNameAndIdNot(String name, Long id, String localName) {
        switch (localName) {
            case IngredientBaseConstants.FIELD_NAME_EN:
                return establishmentTypeRepository.existsByNameEnAndIdNot(name, id);
            case IngredientBaseConstants.FIELD_NAME_RU:
                return establishmentTypeRepository.existsByNameRuAndIdNot(name, id);
            case IngredientBaseConstants.FIELD_NAME_KK:
                return establishmentTypeRepository.existsByNameKkAndIdNot(name, id);
        }
        return false;
    }
}
