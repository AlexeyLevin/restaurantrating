package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.Dish;
import com.alev.restaurantrating.util.exceptions.NotFoundException;

import java.util.Collection;

public interface DishService {
    Dish get(int id, int menuId, int restaurantId) throws NotFoundException;

    void delete(int id, int menuId, int restaurantId) throws NotFoundException;

    Collection<Dish> getAll(int menuId, int restaurantId);

    Dish findByName(String name) throws NotFoundException;

    Dish update(Dish dish, int menuId, int restaurantId);

    Dish create(Dish dish, int menuId, int restaurantId);

    Dish getWithMenu(int id, int menuId, int restaurantId);
}
