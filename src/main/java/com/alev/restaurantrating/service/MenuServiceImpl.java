package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.Menu;
import com.alev.restaurantrating.repository.MenuRepository;
import com.alev.restaurantrating.util.exceptions.ExceptionUtil;
import com.alev.restaurantrating.util.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository repository;

    @Override
    public Menu get(int id, int restaurantId) throws NotFoundException {
        return ExceptionUtil.check(repository.get(id, restaurantId), id);
    }

    @Override
    public void delete(int id, int restaurantId) throws NotFoundException {
        ExceptionUtil.check(repository.delete(id, restaurantId), id);
    }

    @Override
    public Menu save(Menu menu, int restaurantId) {
        return repository.save(menu, restaurantId);
    }

    @Override
    public Menu findByName(String name) throws NotFoundException {
        Objects.requireNonNull(name, "Name must not be empty");
        return ExceptionUtil.check(repository.findByName(name), "name=" + name);
    }

    @Override
    public Menu update(Menu menu, int restaurantId) {
        return ExceptionUtil.check(repository.save(menu, restaurantId), menu.getId());
    }

    @Override
    public Collection<Menu> getAll(int restaurantId) {
        return repository.getAll(restaurantId);
    }

    @Override
    public Menu getWithRestaurant(int id, int restaurantId) {
        return repository.getWithRestaurant(id, restaurantId);
    }

    @Override
    public Menu getWithDishes(int id) {
        return repository.getWithDishes(id);
    }
}
