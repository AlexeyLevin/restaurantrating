package com.alev.restaurantrating.repository.datajpa;

import com.alev.restaurantrating.model.LunchMenu;
import com.alev.restaurantrating.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class DataJpaMenuRepositoryImpl implements MenuRepository {

    @Autowired
    private ProxyMenuRepository proxy;

    @Autowired
    private ProxyRestaurantRepository proxyRestaurantRepository;

    @Override
    public LunchMenu save(LunchMenu lunchMenu, int restaurantId) {
        if (!lunchMenu.isNew() && get(lunchMenu.getId(), restaurantId) == null) {
            return null;
        }
        lunchMenu.setRestaurant(proxyRestaurantRepository.getOne(restaurantId));
        return proxy.save(lunchMenu);
    }

    @Override
    public boolean delete(int id, int restaurantId) {
        return proxy.delete(id, restaurantId) != 0;
    }

    @Override
    public LunchMenu get(int id, int restaurantId) {
        return proxy.get(id, restaurantId);
    }

    @Override
    public Collection<LunchMenu> getAll(int restaurantId) {
        return proxy.getAll(restaurantId);
    }

    @Override
    public LunchMenu findByName(String name) {
        return proxy.findByName(name);
    }

    @Override
    public LunchMenu getWithRestaurant(int id, int restaurantId) {
        return proxy.getWithRestaurant(id, restaurantId);
    }

    @Override
    public LunchMenu getWithDishes(int id) {
        return proxy.getWithDishes(id);
    }
}

//    @Override
//    public LunchMenu get(int id) {
//        return proxy.findOne(id);
//    }
//
