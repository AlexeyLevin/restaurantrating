package com.alev.restaurantrating.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Simple JavaBean domain object adds a name property to <code>BaseEntity</code>. Used as a base class for objects
 * needing these properties.
 */
@MappedSuperclass
public class NamedEntity extends BaseEntity {

    @NotEmpty
    @Column(name = "name", nullable = false)
    protected String name;

    public NamedEntity() {
    }

    protected NamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }
}
