package com.alev.restaurantrating.repository.generic;

import java.io.Serializable;
import java.util.Collection;

public interface GenericRepository<T, ID extends Serializable, PID extends Serializable> {

    // null if updated entity do not belong to parentId
    T save(T entity, ID id, PID parentId);

    // false if entity do not belong to parentId
    boolean delete(T entity, ID id, PID parentId);

    // null if entity do not belong to parentId
    T get(T entity, PID parentId);

    Collection<T> getAll(PID parentId);

    // null if not found
    T findByName(String name);
}
