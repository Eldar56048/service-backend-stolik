package kz.stolik.servicebackendstolik.model.entity.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public abstract class FullNameEntity extends BaseEntity {
    private String firstName;
    private String lastName;
    private String secondName;
}
