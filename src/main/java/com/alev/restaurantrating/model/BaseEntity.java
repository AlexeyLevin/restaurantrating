package com.alev.restaurantrating.model;

import javax.persistence.*;

/**
 * Simple JavaBean domain object with an id property.
 * Used as a base class for objects needing this property.
 */
@MappedSuperclass
@Access(AccessType.FIELD)
//@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setter
// Visibility = NONE)
public class BaseEntity {
    /**
     * Number of the beginning of sequence.
     */
    public static final int START_SEQ = 100000;
    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    protected Integer id;

    public BaseEntity() {
    }

    protected BaseEntity(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public boolean isNew() {
        return (this.id == null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseEntity that = (BaseEntity) o;
        if (id == null || that.id == null) {
            return false;
        }
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return (id == null) ? 0 : id;
    }
}
