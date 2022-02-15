package kz.stolik.servicebackendstolik.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.stolik.servicebackendstolik.exception.domain.BodyObjectIdDoesNotMatchRequestIdCustomException;
import kz.stolik.servicebackendstolik.exception.domain.EstablishmentTypeNotFoundByIdException;
import kz.stolik.servicebackendstolik.model.dto.*;
import kz.stolik.servicebackendstolik.model.entity.EstablishmentType;
import kz.stolik.servicebackendstolik.service.EstablishmentTypeService;
import kz.stolik.servicebackendstolik.service.impl.EstablishmentTypeServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static kz.stolik.servicebackendstolik.constants.swagger.EstablishmentTypeSwaggerConstants.*;


@RestController
@RequestMapping("/establishment-types")
@Tag(name = NAME_OF_ESTABLISHMENT_TYPE_CONTROLLER, description = DESCRIPTION_OF_ESTABLISHMENT_TYPE_CONTROLLER)
public class EstablishmentTypeController {
    private final EstablishmentTypeService establishmentTypeService;

    public EstablishmentTypeController(EstablishmentTypeServiceImpl establishmentTypeService) {
        this.establishmentTypeService = establishmentTypeService;
    }

    @GetMapping
    @Operation(description = DESCRIPTION_OF_API_FOR_RETURNING_PAGE_OF_ESTABLISHMENT_TYPE)
    public ResponseEntity<Page<EstablishmentType>> getAll(Pageable pageable) {
        return ResponseEntity.ok(establishmentTypeService.getAll(pageable));
    }

    @PostMapping("/filter")
    @Operation(description = DESCRIPTION_OF_API_FOR_SEARCH_WITH_FILTER)
    public ResponseEntity<Page<EstablishmentType>> searchWithFilter(@RequestBody List<SearchCriteriaDto> criteriaList, Pageable pageable) {
        return ResponseEntity.ok(establishmentTypeService.searchWithFilter(criteriaList, pageable));
    }

    @PostMapping
    @Operation(description = DESCRIPTION_OF_API_FOR_CREATING_ESTABLISHMENT_TYPE)
    public ResponseEntity<EstablishmentType> create(@RequestBody @Validated EstablishmentTypeCreateDto createDto) {
        return ResponseEntity.ok(establishmentTypeService.create(createDto));
    }

    @PutMapping("/{id}")
    @Operation(description = DESCRIPTION_OF_API_FOR_UPDATING_ESTABLISHMENT_TYPE)
    public ResponseEntity<EstablishmentType> update(@PathVariable  Long id, @RequestBody @Validated EstablishmentTypeUpdateDto updateDto) {
        if (!updateDto.getId().equals(id))
            throw new BodyObjectIdDoesNotMatchRequestIdCustomException();
        if (!establishmentTypeService.existsById(id))
            throw new EstablishmentTypeNotFoundByIdException();
        return ResponseEntity.ok(establishmentTypeService.update(updateDto));
    }
}
