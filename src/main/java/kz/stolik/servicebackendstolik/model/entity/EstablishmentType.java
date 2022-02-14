package kz.stolik.servicebackendstolik.model.entity;

import kz.stolik.servicebackendstolik.model.entity.base.LocalNameEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "establishment_types")
@Getter
@Setter
public class EstablishmentType extends LocalNameEntity {
    private String description;
}
