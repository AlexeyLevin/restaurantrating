package com.alev.restaurantrating.repository.datajpa;

import com.alev.restaurantrating.model.Restaurant;
import com.alev.restaurantrating.repository.RestaurantRepository;
import com.alev.restaurantrating.repository.generic.SimpleGenericRepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public interface DataJpaRestaurantRepositoryImpl extends RestaurantRepository, SimpleGenericRepositoryImpl<Restaurant,Integer> {
}
