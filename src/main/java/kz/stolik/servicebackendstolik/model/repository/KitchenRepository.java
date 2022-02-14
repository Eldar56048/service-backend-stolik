package kz.stolik.servicebackendstolik.model.repository;

import kz.stolik.servicebackendstolik.model.entity.Kitchen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KitchenRepository extends JpaRepository<Kitchen, Long> {
}
