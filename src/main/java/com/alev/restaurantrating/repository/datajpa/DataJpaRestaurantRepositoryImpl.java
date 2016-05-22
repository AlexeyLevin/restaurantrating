package com.alev.restaurantrating.repository.datajpa;

import com.alev.restaurantrating.model.Restaurant;
import com.alev.restaurantrating.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaRestaurantRepositoryImpl implements RestaurantRepository {
    private static final Sort SORT_NAME = new Sort("name");

    @Autowired
    private ProxyRestaurantRepository proxy;

    @Override
    public Restaurant save(Restaurant restaurant) {
        return proxy.save(restaurant);
    }

    @Override
    public boolean delete(int id) {
        return proxy.delete(id) != 0;
    }

    @Override
    public Restaurant get(int id) {
        return proxy.findOne(id);
    }

    @Override
    public Restaurant findByName(String name) {
        return proxy.findByName(name);
    }

    @Override
    public List<Restaurant> getAll() {
        return proxy.findAll(SORT_NAME);
    }

//    @Override
//    public User getWithMenus(int id) {
//        return getWithVotes(id);
//    }
}
