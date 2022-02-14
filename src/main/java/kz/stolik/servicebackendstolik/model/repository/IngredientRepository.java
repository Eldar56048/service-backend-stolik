package kz.stolik.servicebackendstolik.model.repository;

import kz.stolik.servicebackendstolik.model.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long>, JpaSpecificationExecutor<Ingredient> {
    boolean existsByNameEn(String nameEn);
    boolean existsByNameRu(String nameRu);
    boolean existsByNameKk(String nameKk);

    boolean existsByNameEnAndIdNot(String nameEn, Long id);
    boolean existsByNameRuAndIdNot(String nameRu, Long id);
    boolean existsByNameKkAndIdNot(String nameKk, Long id);
}
