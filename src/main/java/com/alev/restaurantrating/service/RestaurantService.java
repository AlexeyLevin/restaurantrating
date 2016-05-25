package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.Restaurant;
import com.alev.restaurantrating.util.exceptions.NotFoundException;

import java.util.List;


public interface RestaurantService {

    Restaurant save(Restaurant restaurant);

    void delete(int id) throws NotFoundException;

    Restaurant get(int id) throws NotFoundException;

    Restaurant findByName(String name) throws NotFoundException;

    void update(Restaurant restaurant);

    List<Restaurant> getAll();
}
