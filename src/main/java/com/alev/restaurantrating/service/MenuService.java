package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.Menu;
import com.alev.restaurantrating.util.exceptions.NotFoundException;

import java.util.Collection;

public interface MenuService {

    Menu get(int id, int restaurantId) throws NotFoundException;

    void delete(int id, int restaurantId) throws NotFoundException;

    Collection<Menu> getAll(int restaurantId);

    Menu findByName(String name) throws NotFoundException;

    Menu update(Menu menu, int restaurantId);

    Menu save(Menu menu, int restaurantId);

    default Menu getWithRestaurant(int id, int restaurantId) throws NotFoundException {
        throw new UnsupportedOperationException();
    }

    default Menu getWithDishes(int id, int restaurantId) throws NotFoundException {
        throw new UnsupportedOperationException();
    }

    Menu getWithDishes(int id);
}
