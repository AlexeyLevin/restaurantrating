package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.LunchMenu;
import com.alev.restaurantrating.repository.MenuRepository;
import com.alev.restaurantrating.util.exceptions.ExceptionUtil;
import com.alev.restaurantrating.util.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository repository;

    @Override
    public LunchMenu get(int id, int restaurantId) throws NotFoundException {
        return ExceptionUtil.check(repository.get(id, restaurantId), id);
    }

    @Override
    public void delete(int id, int restaurantId) throws NotFoundException {
        ExceptionUtil.check(repository.delete(id, restaurantId), id);
    }

    @Override
    public LunchMenu save(LunchMenu lunchMenu, int restaurantId) {
        return repository.save(lunchMenu, restaurantId);
    }

    @Override
    public LunchMenu getByName(String name) throws NotFoundException {
        Objects.requireNonNull(name, "Name must not be empty");
        return ExceptionUtil.check(repository.findByName(name), "name=" + name);
    }

    @Override
    public LunchMenu update(LunchMenu lunchMenu, int restaurantId) {
        return ExceptionUtil.check(repository.save(lunchMenu, restaurantId), lunchMenu.getId());
    }

    @Override
    public Collection<LunchMenu> getAll(int restaurantId) {
        return repository.getAll(restaurantId);
    }

    @Override
    public LunchMenu getWithRestaurant(int id, int restaurantId) {
        return repository.getWithRestaurant(id, restaurantId);
    }

    @Override
    public LunchMenu getWithDishes(int id) {
        return repository.getWithDishes(id);
    }
}
