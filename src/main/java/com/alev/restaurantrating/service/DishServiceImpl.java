package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.Dish;
import com.alev.restaurantrating.repository.DishRepository;
import com.alev.restaurantrating.util.exceptions.ExceptionUtil;
import com.alev.restaurantrating.util.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Objects;

public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository repository;

    @Override
    public Dish get(int id, int menuId) throws NotFoundException {
        return ExceptionUtil.check(repository.get(id, menuId), id);
    }

    @Override
    public void delete(int id, int menuId) throws NotFoundException {
        ExceptionUtil.check(repository.delete(id, menuId), id);
    }

    @Override
    public Dish save(Dish dish, int menuId) {
        return repository.save(dish, menuId);
    }

    @Override
    public Dish getByName(String name) throws NotFoundException {
        Objects.requireNonNull(name, "Name must not be empty");
        return ExceptionUtil.check(repository.findByName(name), "name=" + name);
    }

    @Override
    public Dish update(Dish dish, int menuId) {
        return repository.save(dish, menuId);
    }

    @Override
    public Collection<Dish> getAll(int menuId) {
        return repository.getAll(menuId);
    }
}
