package com.alev.restaurantrating.repository;

import com.alev.restaurantrating.model.Dish;

import java.util.Collection;

public interface DishRepository {
    // null if updated Dish do not belong to restaurantId or menuId
    Dish save(Dish Dish, int menuId, int restaurantId);

    // false if menu do not belong to restaurantId or menuId
    boolean delete(int id, int menuId, int restaurantId);

    // null if menu do not belong to restaurantId or menuId
    Dish get(int id, int menuId, int restaurantId);

    // null if not found
    Dish findByName(String name);

    //ORDERED date
    Collection<Dish> getAll(int menuId, int restaurantId);

    Dish getWithMenu(int id, int menuId, int restaurantId);
}
