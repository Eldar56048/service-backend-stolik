package kz.stolik.servicebackendstolik.model.repository;

import kz.stolik.servicebackendstolik.model.entity.Reason;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReasonRepository extends JpaRepository<Reason, Long> {
}
