package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.User;
import com.alev.restaurantrating.util.exceptions.NotFoundException;

import java.util.List;


public interface UserService {

    User save(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    List<User> getAll();

    void update(User user);
}
