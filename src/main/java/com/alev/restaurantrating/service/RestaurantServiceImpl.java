package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.Restaurant;
import com.alev.restaurantrating.repository.RestaurantRepository;
import com.alev.restaurantrating.util.exceptions.ExceptionUtil;
import com.alev.restaurantrating.util.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository repository;

    @Override
    public Restaurant save(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        ExceptionUtil.check(repository.delete(id), id);
    }

    @Override
    public Restaurant get(int id) throws NotFoundException {
        return ExceptionUtil.check(repository.get(id), id);
    }

    @Override
    public Restaurant findByName(String name) throws NotFoundException {
        Objects.requireNonNull(name, "Name must not be empty");
        return ExceptionUtil.check(repository.findByName(name), "name=" + name);
    }

    @Override
    public void update(Restaurant restaurant) {
        repository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAll() {
        return repository.getAll();
    }
}