package com.alev.restaurantrating.repository.datajpa;

import com.alev.restaurantrating.model.Menu;
import com.alev.restaurantrating.model.Restaurant;
import com.alev.restaurantrating.repository.MenuRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface DataJpaMenuRepositoryImpl extends MenuRepository, JpaRepository<Menu, Integer> {

    @Query("SELECT r FROM Restaurant r WHERE r.id=:id")
    Restaurant getRestaurant(@Param("id") int id);

    @Override
    @Transactional
    default Menu save(Menu menu, int restaurantId) {
        if (!menu.isNew() && get(menu.getId(), restaurantId) == null) {
            return null;
        }
        menu.setRestaurant(getRestaurant(restaurantId));
        return save(menu);
    }

    @Override
    @Transactional
    Menu save(Menu menu);

    @Override
    @Transactional
    @Modifying
    default boolean delete(int id, int restaurantId) {
        return deleting(id, restaurantId) != 0;
    }

    @Transactional
    @Modifying
    @Query("DELETE FROM Menu m WHERE m.id=:id AND m.restaurant.id=:restaurantId")
    int deleting(@Param("id") int id, @Param("restaurantId") int restaurantId);

    @Query("SELECT m FROM Menu m WHERE m.id=:id AND m.restaurant.id=:restaurantId")
    @Override
    Menu get(@Param("id") int id, @Param("restaurantId") int restaurantId);

    @Override
    @Query("SELECT m FROM Menu m WHERE m.restaurant.id=:restaurantId ORDER BY m.date DESC")
    List<Menu> getAll(@Param("restaurantId") int restaurantId);

    @Query("SELECT m FROM Menu m JOIN FETCH m.restaurant WHERE m.id = :id and m.restaurant.id = :restaurantId")
    @Override
    Menu getWithRestaurant(@Param("id")int id, @Param("restaurantId") int restaurantId);

    @Query("SELECT m FROM Menu m LEFT JOIN FETCH m.dishes WHERE m.id=:id")
    @Override
    Menu getWithDishes(@Param("id")int id);

    @Override
    Menu findOne(Integer id);

    @Override
    Menu findByName(String name);
}