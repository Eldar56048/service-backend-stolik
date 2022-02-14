package kz.stolik.servicebackendstolik.specification.base;

import kz.stolik.servicebackendstolik.model.dto.SearchCriteriaDto;
import kz.stolik.servicebackendstolik.model.enums.SearchOperation;
import kz.stolik.servicebackendstolik.utils.CommonUtils;
import kz.stolik.servicebackendstolik.utils.DateUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseSpecification<SpecificationClass> implements Specification<SpecificationClass> {
    private List<SearchCriteriaDto> criteriaList;
    private Class aClass;

    public BaseSpecification(List<SearchCriteriaDto> criteriaList, Class aClass) {
        this.criteriaList = criteriaList;
        this.aClass = aClass;
    }

    @Override
    public Predicate toPredicate(Root<SpecificationClass> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        for(SearchCriteriaDto searchCriteria : criteriaList) {
            if (searchCriteria.getValue() != null) {
                if ((searchCriteria.getValue().getClass() == String.class && !searchCriteria.getValue().equals("")) ||
                        (searchCriteria.getValue().getClass() == Boolean.class && searchCriteria.getValue() != null) ||
                        (searchCriteria.getValue().getClass() == Integer.class && searchCriteria.getValue() != null) ||
                        (searchCriteria.getValue().getClass() == Long.class && searchCriteria.getValue() != null)
                ) {
                    Field field = CommonUtils.getField(searchCriteria.getKey(), aClass);
                    Class<?> type = field.getType();
                    if (searchCriteria.getOperation().equals(SearchOperation.EQUAL)) {
                        if (type.isAssignableFrom(Date.class)) {
                            Date date = new Date((long) searchCriteria.getValue());
                            Date dateStart = DateUtils.getDayStart(date);
                            Date dateEnd = DateUtils.getDayEnd(date);
                            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(searchCriteria.getKey()), dateStart));
                            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(searchCriteria.getKey()), dateEnd));
                        } else {
                            predicates.add(criteriaBuilder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue()));
                        }
                    }
                }
            }
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
