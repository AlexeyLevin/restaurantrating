package com.alev.restaurantrating.repository.generic;

import java.io.Serializable;
import java.util.List;

public interface SimpleGenericRepository<T, ID extends Serializable> {

    <S extends T> S save(S entity);

    // false if not found
    boolean deleting(ID id);

    // null if not found
    T get(ID id);

    // null if not found
    T findByName(String name);

    T getWithFields(ID id);

    List<T> getAll();
}
