package com.alev.restaurantrating.repository;

import com.alev.restaurantrating.model.LunchMenu;

import java.util.Collection;

public interface MenuRepository {

    // null if updated lunchMenu do not belong to restaurantId
    LunchMenu save(LunchMenu lunchMenu, int restaurantId);

    // false if menu do not belong to restaurantId
    boolean delete(int id, int restaurantId);

    // null if menu do not belong to restaurantId
    LunchMenu get(int id, int restaurantId);

    // null if not found
    LunchMenu findByName(String name);

    //ORDERED date
    Collection<LunchMenu> getAll(int restaurantId);

    default LunchMenu getWithDishes(int id, int restaurantId) {
        throw new UnsupportedOperationException();
    }

    default LunchMenu getWithRestaurant(int id, int restaurantId) {
        throw new UnsupportedOperationException();
    }
}
