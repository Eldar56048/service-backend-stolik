package kz.stolik.servicebackendstolik.model.repository;

import kz.stolik.servicebackendstolik.model.entity.EstablishmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablishmentTypeRepository extends JpaRepository<EstablishmentType, Long>, JpaSpecificationExecutor<EstablishmentType> {
    boolean existsByNameRu(String nameRu);
    boolean existsByNameKk(String nameKk);
    boolean existsByNameEn(String nameEn);

    boolean existsByNameRuAndIdNot(String nameRu, Long id);
    boolean existsByNameKkAndIdNot(String nameKk, Long id);
    boolean existsByNameEnAndIdNot(String nameEn, Long id);
}
