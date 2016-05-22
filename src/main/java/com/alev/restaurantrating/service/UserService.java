package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.User;
import com.alev.restaurantrating.to.UserTo;
import com.alev.restaurantrating.util.exceptions.NotFoundException;

import java.util.List;


public interface UserService {

    User save(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    void update(UserTo user);

    List<User> getAll();

    void update(User user);

    void evictCache();

    void enable(int id, boolean enable);

    default User getWithVotes(int id) {
        throw new UnsupportedOperationException();
    }
}
