package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.Restaurant;

import java.util.Collection;

public interface RestaurantService {
    Restaurant get(int id);

    void delete(int id);

    Collection<Restaurant> getAll();

    Restaurant save(Restaurant restaurant);

    Restaurant update(Restaurant restaurant);
}
