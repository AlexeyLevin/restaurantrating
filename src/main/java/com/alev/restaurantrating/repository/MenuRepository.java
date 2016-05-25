package com.alev.restaurantrating.repository;

import com.alev.restaurantrating.model.Menu;

import java.util.Collection;

public interface MenuRepository {

    // null if updated menu do not belong to restaurantId
    Menu save(Menu menu, int restaurantId);

    // false if menu do not belong to restaurantId
    boolean delete(int id, int restaurantId);

    // null if menu do not belong to restaurantId
    Menu get(int id, int restaurantId);

    // null if not found
    Menu findByName(String name);

    //ORDERED date
    Collection<Menu> getAll(int restaurantId);

    Menu getWithRestaurant(int id, int restaurantId);

    Menu getWithDishes(int id);

//    default Menu getWithDishes(int id, int restaurantId) {
//        throw new UnsupportedOperationException();
//    }
}
