package com.alev.restaurantrating.repository.datajpa;

import com.alev.restaurantrating.model.Dish;
import com.alev.restaurantrating.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
public class DataJpaDishRepositoryImpl implements DishRepository{

    @Autowired
    private ProxyDishRepository proxy;

    @Autowired
    private ProxyMenuRepository proxyMenuRepository;

    @Override
    @Transactional
    public Dish save(Dish dish, int menuId, int restaurantId) {
        if (!dish.isNew() && get(dish.getId(), menuId, restaurantId) == null) {
            return null;
        }
        dish.setMenu(proxyMenuRepository.getOne(menuId));
        return proxy.save(dish);
    }

    @Override
    @Transactional
    public boolean delete(int id, int menuId, int restaurantId) {
        if (proxyMenuRepository.get(menuId, restaurantId) == null) {
            return false;
        }
        return proxy.delete(id, menuId) != 0;
    }

    @Override
    @Transactional
    public Dish get(int id, int menuId, int restaurantId) {
        if (proxyMenuRepository.get(menuId, restaurantId) == null) {
            return null;
        }
        return proxy.get(id, menuId);
    }

    @Override
    @Transactional
    public Collection<Dish> getAll(int menuId, int restaurantId) {
        if (proxyMenuRepository.get(menuId, restaurantId) == null) {
            return null;
        }
        return proxy.getAll(menuId);
    }

    @Override
    public Dish findByName(String name) {
        return proxy.findByName(name);
    }

    @Override
    public Dish getWithMenu(int id, int menuId, int restaurantId) {
        if (proxyMenuRepository.get(menuId, restaurantId) == null) {
            return null;
        }
        return proxy.getWithMenu(id, menuId);
    }
}
