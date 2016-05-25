package com.alev.restaurantrating.repository.datajpa;

import com.alev.restaurantrating.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface ProxyMenuRepository extends JpaRepository<Menu, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Menu m WHERE m.id=:id AND m.restaurant.id=:restaurantId")
    int delete(@Param("id") int id, @Param("restaurantId") int restaurantId);

    @Override
    @Transactional
    Menu save(Menu menu);

    @Override
    Menu findOne(Integer id);

    @Query("SELECT m FROM Menu m WHERE m.id=:id AND m.restaurant.id=:restaurantId")
    Menu get(@Param("id") int id, @Param("restaurantId") int restaurantId);

    @Query("SELECT m FROM Menu m WHERE m.restaurant.id=:restaurantId ORDER BY m.menuDate DESC")
    List<Menu> getAll(@Param("restaurantId") int restaurantId);

    Menu findByName(String name);

    @Query("SELECT m FROM Menu m JOIN FETCH m.restaurant WHERE m.id = :id and m.restaurant.id = :restaurantId")
    Menu getWithRestaurant(@Param("id")int id, @Param("restaurantId") int restaurantId);

    @Query("SELECT m FROM Menu m LEFT JOIN FETCH m.dishes WHERE m.id=:id")
    Menu getWithDishes(@Param("id")int id);
}
