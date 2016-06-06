package com.alev.restaurantrating.repository.datajpa;

import com.alev.restaurantrating.model.User;
import com.alev.restaurantrating.repository.UserRepository;
import com.alev.restaurantrating.repository.generic.SimpleGenericRepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public interface DataJpaUserRepositoryImpl extends UserRepository, SimpleGenericRepositoryImpl<User, Integer> {
}