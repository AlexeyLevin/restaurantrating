package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.LunchMenu;

import java.util.Collection;

public interface MenuService {

    LunchMenu get(int id, int restaurantId);

    void delete(int id, int restaurantId);

    Collection<LunchMenu> getAll(int restaurantId);

    LunchMenu save(LunchMenu lunchMenu, int restaurantId);

    LunchMenu update(LunchMenu lunchMenu, int restaurantId);
}
