package com.alev.restaurantrating.repository.datajpa;

import com.alev.restaurantrating.model.LunchMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface ProxyMenuRepository extends JpaRepository<LunchMenu, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM LunchMenu m WHERE m.id=:id AND m.restaurant.id=:restaurantId")
    int delete(@Param("id") int id, @Param("restaurantId") int restaurantId);

    @Override
    @Transactional
    LunchMenu save(LunchMenu lunchMenu);

    @Override
    LunchMenu findOne(Integer id);

    @Query("SELECT m FROM LunchMenu m WHERE m.id=:id AND m.restaurant.id=:restaurantId")
    LunchMenu get(@Param("id") int id, @Param("restaurantId") int restaurantId);

    @Query("SELECT m FROM LunchMenu m WHERE m.restaurant.id=:restaurantId ORDER BY m.menuDate DESC")
    List<LunchMenu> getAll(@Param("restaurantId") int restaurantId);

    LunchMenu findByName(String name);

    @Query("SELECT m FROM LunchMenu m JOIN FETCH m.restaurant WHERE m.id = :id and m.restaurant.id = :restaurantId")
    LunchMenu getWithRestaurant(@Param("id")int id,@Param("restaurantId") int restaurantId);

    @Query("SELECT m FROM LunchMenu m LEFT JOIN FETCH m.dishes WHERE m.id=:id")
    LunchMenu getWithDishes(@Param("id")int id);
}
