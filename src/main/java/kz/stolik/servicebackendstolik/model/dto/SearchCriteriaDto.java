package kz.stolik.servicebackendstolik.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import kz.stolik.servicebackendstolik.model.enums.SearchOperation;
import lombok.Getter;
import lombok.Setter;

import static kz.stolik.servicebackendstolik.constants.swagger.SearchCriteriaDtoSwaggerConstants.*;

@Getter
@Setter
@Schema(title = SEARCH_CRITERIA_DTO_TITLE)
public class SearchCriteriaDto {
    @Schema(description = FIELD_KEY_DESCRIPTION, example = FIELD_KEY_EXAMPLE, required = true)
    private String key;
    @Schema(description = FIELD_VALUE_DESCRIPTION, example = FIELD_VALUE_EXAMPLE, required = true)
    private Object value;
    private Object value2;
    @Schema(description = FIELD_OPERATION_DESCRIPTION, example = FIELD_OPERATION_EXAMPLE, required = true)
    private SearchOperation operation;
}
