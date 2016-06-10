package com.alev.restaurantrating.repository;

import com.alev.restaurantrating.model.Restaurant;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
interface RestaurantRepositoryImpl extends RestaurantRepository, JpaRepository<Restaurant, Integer> {
    Sort SORT_NAME = new Sort("name");

    @Override
    @Transactional
    Restaurant save(Restaurant restaurant);

    @Transactional
    @Modifying
    @Override
    default boolean delete(int id) {
        return deleting(id) != 0;
    }

    @Transactional
    @Modifying
    @Query("DELETE FROM Restaurant r WHERE r.id=:id")
    int deleting(@Param("id") int id);

    @Override
    default Restaurant get(int id) {
        return findOne(id);
    }

    @Override
    default List<Restaurant> getAll() {
        return findAll(SORT_NAME);
    }

    @Override
    List<Restaurant> findAll(Sort sort);

    @Override
    Restaurant findOne(Integer id);

    @Override
    Restaurant findByName(String name);

//    @Query("SELECT r FROM Restaurant r LEFT JOIN FETCH r.menus WHERE r.id = ?1")
//    Restaurant getWithMenus(Integer id);

//    @Override
//    public Restaurant getWithMenus(int id) {
//        return proxy.getWithMenus(id);
//    }
}
