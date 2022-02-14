package kz.stolik.servicebackendstolik.model.entity;

import kz.stolik.servicebackendstolik.model.entity.base.LocalNameEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "kitchens")
public class Kitchen extends LocalNameEntity {
}
