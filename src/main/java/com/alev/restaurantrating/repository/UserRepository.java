package com.alev.restaurantrating.repository;

import com.alev.restaurantrating.model.User;
import com.alev.restaurantrating.repository.generic.SimpleGenericRepository;

public interface UserRepository extends SimpleGenericRepository<User, Integer> {
    User getByEmail(String email);
}
