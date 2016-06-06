package com.alev.restaurantrating.repository.datajpa;

import com.alev.restaurantrating.model.Menu;
import com.alev.restaurantrating.repository.MenuRepository;
import com.alev.restaurantrating.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class DataJpaMenuRepositoryImpl implements MenuRepository {

    @Autowired
    private ProxyMenuRepository proxy;

    @Autowired
    private RestaurantRepository repository;

    @Override
    public Menu save(Menu menu, int restaurantId) {
        if (!menu.isNew() && get(menu.getId(), restaurantId) == null) {
            return null;
        }
        menu.setRestaurant(repository.get(restaurantId));
        return proxy.save(menu);
    }

    @Override
    public boolean delete(int id, int restaurantId) {
        return proxy.delete(id, restaurantId) != 0;
    }

    @Override
    public Menu get(int id, int restaurantId) {
        return proxy.get(id, restaurantId);
    }

    @Override
    public Collection<Menu> getAll(int restaurantId) {
        return proxy.getAll(restaurantId);
    }

    @Override
    public Menu findByName(String name) {
        return proxy.findByName(name);
    }

    @Override
    public Menu getWithRestaurant(int id, int restaurantId) {
        return proxy.getWithRestaurant(id, restaurantId);
    }

    @Override
    public Menu getWithDishes(int id) {
        return proxy.getWithDishes(id);
    }
}

//    @Override
//    public Menu get(int id) {
//        return proxy.findOne(id);
//    }
//
