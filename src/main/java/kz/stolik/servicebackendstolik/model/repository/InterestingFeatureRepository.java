package kz.stolik.servicebackendstolik.model.repository;

import kz.stolik.servicebackendstolik.model.entity.InterestingFeature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestingFeatureRepository extends JpaRepository<InterestingFeature, Long> {
}
