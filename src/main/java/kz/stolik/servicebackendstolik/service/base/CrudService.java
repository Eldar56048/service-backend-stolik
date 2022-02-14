package kz.stolik.servicebackendstolik.service.base;

import kz.stolik.servicebackendstolik.model.dto.SearchCriteriaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CrudService<Class, CreateDto, UpdateDto>{
    Page<Class> getAll(Pageable pageable);
    Page<Class> searchWithFilter(List<SearchCriteriaDto> criteria, Pageable pageable);
    Class create(CreateDto createDto);
    Class getById(Long id);
    Class update(UpdateDto updateDto);
    Class save(Class model);
    boolean existsById(Long id);
}
