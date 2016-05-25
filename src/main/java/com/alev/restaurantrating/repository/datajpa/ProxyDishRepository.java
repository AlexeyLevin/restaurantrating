package com.alev.restaurantrating.repository.datajpa;

import com.alev.restaurantrating.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProxyDishRepository extends JpaRepository<Dish, Integer> {

    @Query("SELECT m FROM Dish m WHERE m.id=:id AND m.menu.id=:menuId")
    Dish get(@Param("id") int id, @Param("menuId") int menuId);

    @Query("SELECT m FROM Dish m WHERE m.menu.id=:menuId ORDER BY m.name ASC")
    List<Dish> getAll(@Param("menuId") int menuId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Dish m WHERE m.id=:id AND m.menu.id=:menuId")
    int delete(@Param("id") int id, @Param("menuId") int menuId);

    @Override
    @Transactional
    Dish save(Dish dish);

//@Query("SELECT m FROM Menu m JOIN FETCH m.restaurant WHERE m.id = :id and m.restaurant.id = :restaurantId")
    @Query("SELECT d FROM Dish d JOIN FETCH d.menu WHERE d.id = :id and d.menu.id = :menuId")
    Dish getWithMenu(@Param("id") int id, @Param("menuId") int menuId);

    @Override
    Dish findOne(Integer id);

    Dish findByName(String name);
}
