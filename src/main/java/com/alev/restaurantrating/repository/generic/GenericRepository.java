package com.alev.restaurantrating.repository.generic;

import java.io.Serializable;
import java.util.Collection;

public interface GenericRepository<T, ID extends Serializable, PID extends Serializable> {

    // null if updated entity do not belong to parentId
    <S extends T> S save(S entity);

    // false if entity do not belong to parentId
    boolean deleting(ID id, PID parentId);

    T getWithFields(ID id, PID parentId);

    // null if entity do not belong to parentId
    T get(ID id, PID parentId);

    Collection<T> getAll(PID parentId);

    // null if not found
    T findByName(String name);
}
