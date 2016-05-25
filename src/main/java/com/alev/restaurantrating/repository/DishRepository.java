package com.alev.restaurantrating.repository;

import com.alev.restaurantrating.model.Dish;

import java.util.Collection;

public interface DishRepository {
    // null if updated Dish do not belong to restaurantId
    Dish save(Dish Dish, int menuId);

    // false if menu do not belong to restaurantId
    boolean delete(int id, int menuId);

    // null if menu do not belong to restaurantId
    Dish get(int id, int menuId);

    // null if not found
    Dish findByName(String name);

    //ORDERED date
    Collection<Dish> getAll(int menuId);

    Dish getWithMenu(int id, int menuId);
}
