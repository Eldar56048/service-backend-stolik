package kz.stolik.servicebackendstolik.model.dto;

import kz.stolik.servicebackendstolik.model.enums.SearchOperation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchCriteriaDto {
    private String key;
    private Object value;
    private Object value2;
    private SearchOperation operation;
}
