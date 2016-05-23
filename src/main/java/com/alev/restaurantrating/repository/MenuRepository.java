package com.alev.restaurantrating.repository;

import com.alev.restaurantrating.model.LunchMenu;

import java.util.List;

public interface MenuRepository {
    LunchMenu save(LunchMenu lunchMenu);

    // false if not found
    boolean delete(int id);

    // null if not found
    LunchMenu get(int id);

    // null if not found
    LunchMenu findByName(String name);

    List<LunchMenu> getAll();

    default LunchMenu getWithDishes(int id){
        throw new UnsupportedOperationException();
    }
}
