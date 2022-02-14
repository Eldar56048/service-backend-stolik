package kz.stolik.servicebackendstolik.model.entity;

import kz.stolik.servicebackendstolik.model.entity.base.LocalNameEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "reasons")
public class Reason extends LocalNameEntity {
    private String description;
}
