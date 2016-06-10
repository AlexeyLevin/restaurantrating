package com.alev.restaurantrating.repository;

import com.alev.restaurantrating.model.Dish;
import com.alev.restaurantrating.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Repository
@Transactional(readOnly = true)
interface DishRepositoryImpl extends JpaRepository<Dish, Integer>, DishRepository {

    @Override
    @Transactional
    default Dish save(Dish dish, int menuId, int restaurantId) {
        if (!dish.isNew() && get(dish.getId(), menuId, restaurantId) == null) {
            return null;
        }
        dish.setMenu(getMenu(menuId, restaurantId));
        return save(dish);
    }

    @Query("SELECT m FROM Menu m WHERE m.id=:id AND m.restaurant.id=:restaurantId")
    Menu getMenu(@Param("id") int id, @Param("restaurantId") int restaurantId);

    @Override
    @Transactional
    Dish save(Dish dish);

    @Override
    @Transactional
    default boolean delete(int id, int menuId, int restaurantId) {
        if (getMenu(menuId, restaurantId) == null) {
            return false;
        }
        return delete(id, menuId) != 0;
    }

    @Modifying
    @Transactional
    @Query("DELETE FROM Dish m WHERE m.id=:id AND m.menu.id=:menuId")
    int delete(@Param("id") int id, @Param("menuId") int menuId);

    @Override
    @Transactional
    default Dish get(int id, int menuId, int restaurantId) {
        if (getMenu(menuId, restaurantId) == null) {
            return null;
        }
        return get(id, menuId);
    }

    @Query("SELECT m FROM Dish m WHERE m.id=:id AND m.menu.id=:menuId")
    Dish get(@Param("id") int id, @Param("menuId") int menuId);

    @Override
    @Transactional
    default Collection<Dish> getAll(int menuId, int restaurantId) {
        if (getMenu(menuId, restaurantId) == null) {
            return null;
        }
        return getAll(menuId);
    }

    @Query("SELECT m FROM Dish m WHERE m.menu.id=:menuId ORDER BY m.name ASC")
    List<Dish> getAll(@Param("menuId") int menuId);

    @Override
    @Transactional
    default Dish getWithMenu(int id, int menuId, int restaurantId) {
        if (getMenu(menuId, restaurantId) == null) {
            return null;
        }
        return getWithMenu(id, menuId);
    }

    //@Query("SELECT m FROM Menu m JOIN FETCH m.restaurant WHERE m.id = :id and m.restaurant.id = :restaurantId")
    @Query("SELECT d FROM Dish d JOIN FETCH d.menu WHERE d.id = :id and d.menu.id = :menuId")
    Dish getWithMenu(@Param("id") int id, @Param("menuId") int menuId);

    @Override
    Dish findOne(Integer id);

    Dish findByName(String name);
}
