package com.alev.restaurantrating.repository;

import com.alev.restaurantrating.model.Restaurant;
import com.alev.restaurantrating.model.User;

import java.util.List;

public interface RestaurantRepository {
    Restaurant save(Restaurant restaurant);

    // false if not found
    boolean delete(int id);

    // null if not found
    Restaurant get(int id);

    // null if not found
    Restaurant findByName(String name);

    List<Restaurant> getAll();

    default User getWithMenus(int id){
        throw new UnsupportedOperationException();
    }
}
