package kz.stolik.servicebackendstolik.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.stolik.servicebackendstolik.exception.domain.BodyObjectIdDoesNotMatchRequestIdCustomException;
import kz.stolik.servicebackendstolik.exception.domain.IngredientNotFoundByIdException;
import kz.stolik.servicebackendstolik.model.dto.IngredientCreateDto;
import kz.stolik.servicebackendstolik.model.dto.IngredientUpdateDto;
import kz.stolik.servicebackendstolik.model.dto.SearchCriteriaDto;
import kz.stolik.servicebackendstolik.model.entity.Ingredient;
import kz.stolik.servicebackendstolik.service.IngredientService;
import kz.stolik.servicebackendstolik.service.impl.IngredientServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.DESCRIPTION_OF_API_FOR_CREATING_INGREDIENT;
import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.DESCRIPTION_OF_API_FOR_UPDATING_INGREDIENT;
import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.NAME_OF_INGREDIENT_CONTROLLER;
import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.DESCRIPTION_OF_INGREDIENT_CONTROLLER;
import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.DESCRIPTION_OF_API_FOR_RETURNING_PAGE_OF_INGREDIENT;
import static kz.stolik.servicebackendstolik.constants.swagger.IngredientSwaggerConstants.DESCRIPTION_OF_API_FOR_SEARCH_WITH_FILTER;

@RestController
@RequestMapping("/ingredients")
@Tag(name = NAME_OF_INGREDIENT_CONTROLLER, description = DESCRIPTION_OF_INGREDIENT_CONTROLLER)
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientServiceImpl ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    @Operation(description = DESCRIPTION_OF_API_FOR_RETURNING_PAGE_OF_INGREDIENT)
    public ResponseEntity<Page<Ingredient>> getAll(Pageable pageable) {
        return ResponseEntity.ok(ingredientService.getAll(pageable));
    }

    @PostMapping("/filter")
    @Operation(description = DESCRIPTION_OF_API_FOR_SEARCH_WITH_FILTER)
    public ResponseEntity<Page<Ingredient>> searchWithFilter(@RequestBody List<SearchCriteriaDto> criteriaList, Pageable pageable) {
        return ResponseEntity.ok(ingredientService.searchWithFilter(criteriaList, pageable));
    }

    @PostMapping
    @Operation(description = DESCRIPTION_OF_API_FOR_CREATING_INGREDIENT)
    public ResponseEntity<Ingredient> create(@RequestBody @Validated IngredientCreateDto createDto) {
        return ResponseEntity.ok(ingredientService.create(createDto));
    }

    @PutMapping("/{id}")
    @Operation(description = DESCRIPTION_OF_API_FOR_UPDATING_INGREDIENT)
    public ResponseEntity<Ingredient> update(@PathVariable  Long id, @RequestBody @Validated IngredientUpdateDto updateDto) {
        if (!updateDto.getId().equals(id))
            throw new BodyObjectIdDoesNotMatchRequestIdCustomException();
        if (!ingredientService.existsById(id))
            throw new IngredientNotFoundByIdException();
        return ResponseEntity.ok(ingredientService.update(updateDto));
    }
}
