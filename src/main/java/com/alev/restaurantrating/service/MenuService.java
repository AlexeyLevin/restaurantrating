package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.LunchMenu;
import com.alev.restaurantrating.util.exceptions.NotFoundException;

import java.util.Collection;

public interface MenuService {

    LunchMenu get(int id, int restaurantId) throws NotFoundException;

    void delete(int id, int restaurantId) throws NotFoundException;

    Collection<LunchMenu> getAll(int restaurantId);

    LunchMenu getByName(String name) throws NotFoundException;

    LunchMenu update(LunchMenu lunchMenu, int restaurantId);

    LunchMenu save(LunchMenu lunchMenu, int restaurantId);

    default LunchMenu getWithRestaurant(int id, int restaurantId) throws NotFoundException {
        throw new UnsupportedOperationException();
    }

    default LunchMenu getWithDishes(int id, int restaurantId) throws NotFoundException {
        throw new UnsupportedOperationException();
    }
}
