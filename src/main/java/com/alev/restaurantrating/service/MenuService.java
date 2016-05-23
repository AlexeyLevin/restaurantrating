package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.LunchMenu;
import com.alev.restaurantrating.util.exceptions.NotFoundException;

import java.util.List;

public interface MenuService {

    LunchMenu save(LunchMenu lunchMenu);

    void delete(int id) throws NotFoundException;;

    LunchMenu get(int id) throws NotFoundException;;

    LunchMenu getByName(String name) throws NotFoundException;

    void update(LunchMenu lunchMenu);

    List<LunchMenu> getAll();
}
