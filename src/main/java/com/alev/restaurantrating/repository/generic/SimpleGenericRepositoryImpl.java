package com.alev.restaurantrating.repository.generic;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(readOnly = true)
public interface SimpleGenericRepositoryImpl<T, ID extends Integer> extends JpaRepository<T, ID>, SimpleGenericRepository<T, ID> {

    Sort SORT_NAME = new Sort("name");

    @Transactional
    @Override
    <S extends T> S save(S entity);

    @Transactional
    @Modifying
    default boolean deleting(ID id) {
        return this.delete(id.intValue()) != 0;
    }

    @Transactional
    @Modifying
    @Query("DELETE FROM #{#entityName} T WHERE T.id = ?1")
    int delete(int id);

    @Transactional
    @Modifying
    @Override
    void delete(ID id);

    @Override
    default T get(ID id) {
        return findOne(id);
    }

    @Override
    default List<T> getAll() {
        return this.findAll(SORT_NAME);
    }

    @Override
    T findByName(String name);

    @Override
    T findOne(ID id);

    @Override
    List<T> findAll(Sort sort);

    @Override
    default T getWithFields(ID id) {
        throw new UnsupportedOperationException();
    }

//    @Query("SELECT r FROM Restaurant r LEFT JOIN FETCH r.menus WHERE r.id = ?1")
//    Restaurant getWithField(Integer id);
}
