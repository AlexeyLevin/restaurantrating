package com.alev.restaurantrating.web.restaurant;

import com.alev.restaurantrating.model.Restaurant;
import com.alev.restaurantrating.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractRestaurantController {
    private final Logger LOG = LoggerFactory.getLogger(AbstractRestaurantController.class);

    @Autowired
    private RestaurantService restaurantService;

    public List<Restaurant> getAll() {
        LOG.info("getAll");
        return restaurantService.getAll();
    }

    public Restaurant get(int id) {
        LOG.info("get " + id);
        return restaurantService.get(id);
    }

    public Restaurant create(Restaurant restaurant) {
        restaurant.setId(null);
        LOG.info("create " + restaurant);
        return restaurantService.save(restaurant);
    }

    public void delete(int id) {
        LOG.info("delete " + id);
        restaurantService.delete(id);
    }

    public void update(Restaurant restaurant, int id) {
        restaurant.setId(id);
        LOG.info("update " + restaurant);
        restaurantService.update(restaurant);
    }

//    public Restaurant getWithMenus(int id) {
//        LOG.info("get " + id);
//        return restaurantService.getWithMenus(id);
//    }

//    public Restaurant getByName(String name) {
//        LOG.info("getByName " + name);
//        return restaurantService.getByName(name);
//    }
}