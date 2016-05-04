package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.LunchMenu;

import java.util.Collection;

public interface MenuService {
    LunchMenu get(int id);

    void delete(int id);

    Collection<LunchMenu> getAll();

    LunchMenu save(LunchMenu lunchMenu);

    LunchMenu update(LunchMenu lunchMenu);
}
