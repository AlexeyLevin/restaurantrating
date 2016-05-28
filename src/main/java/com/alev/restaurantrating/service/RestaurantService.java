package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.Restaurant;
import com.alev.restaurantrating.util.exceptions.NotFoundException;

import java.time.LocalDate;
import java.util.List;


public interface RestaurantService {

    Restaurant save(Restaurant restaurant);

    void delete(int id) throws NotFoundException;

    Restaurant get(int id) throws NotFoundException;

    Restaurant findByName(String name) throws NotFoundException;

    void update(Restaurant restaurant);

    List<Restaurant> getAll();

    default Restaurant getWithTodayMenu(int id) throws NotFoundException {
        throw new UnsupportedOperationException();
    }

    default Restaurant getWithMenus(int id) throws NotFoundException {
        throw new UnsupportedOperationException();
    }

    default Restaurant getWithMenu(int id, int menuId) throws NotFoundException {
        throw new UnsupportedOperationException();
    }

    default Restaurant getWithMenuByDate(int id, LocalDate date) throws NotFoundException {
        throw new UnsupportedOperationException();
    }
}
