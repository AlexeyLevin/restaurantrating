package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.Dish;
import com.alev.restaurantrating.repository.DishRepository;
import com.alev.restaurantrating.repository.MenuRepository;
import com.alev.restaurantrating.util.exceptions.ExceptionUtil;
import com.alev.restaurantrating.util.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Objects;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository repository;

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Dish get(int id, int menuId, int restaurantId) throws NotFoundException {
        return ExceptionUtil.check(repository.get(id, menuId, restaurantId), id);
    }

    @Override
    public void delete(int id, int menuId, int restaurantId) throws NotFoundException {
        ExceptionUtil.check(repository.delete(id, menuId, restaurantId), id);
    }

    @Override
    public Dish create(Dish dish, int menuId, int restaurantId) {
        return repository.save(dish, menuId, restaurantId);
    }

    @Override
    public Dish findByName(String name) throws NotFoundException {
        Objects.requireNonNull(name, "Name must not be empty");
        return ExceptionUtil.check(repository.findByName(name), "name=" + name);
    }

    @Override
    public Dish update(Dish dish, int menuId, int restaurantId) {
        return repository.save(dish, menuId, restaurantId);
    }

    @Override
    public Collection<Dish> getAll(int menuId, int restaurantId) {
        return repository.getAll(menuId, restaurantId);
    }

    @Override
    @Transactional
    public Dish getWithMenu(int id, int menuId, int restaurantId) throws NotFoundException {
        return repository.getWithMenu(id, menuId, restaurantId);
    }
}
