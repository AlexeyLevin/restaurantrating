package com.alev.restaurantrating.web.dish;

import com.alev.restaurantrating.model.Dish;
import com.alev.restaurantrating.service.DishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class AbstractDishController {
    private final Logger LOG = LoggerFactory.getLogger(AbstractDishController.class);

    @Autowired
    private DishService dishService;


    public Dish get(int id, int menuId, int restaurantId) {
        LOG.info("get dish {} for Menu {} of Restaurant ", id, menuId, restaurantId);
        return dishService.get(id, menuId, restaurantId);
    }

    public Dish getWithMenu(int id, int menuId, int restaurantId)  {
        LOG.info("getWithMenu {} for Menu {} of Restaurant ", id, menuId, restaurantId);
        return dishService.getWithMenu(id, menuId, restaurantId);
    }

    public void delete(int id, int menuId, int restaurantId) {
        LOG.info("delete dish {} for Menu {} of Restaurant ", id, menuId, restaurantId);
        dishService.delete(id, menuId, restaurantId);
    }

    public Collection<Dish> getAll(int menuId, int restaurantId) {
        LOG.info("getAll for Menu {} of Restaurant ", menuId, restaurantId);
        return dishService.getAll(menuId, restaurantId);
    }

    public void update(Dish dish, int id, int menuId, int restaurantId) {
        dish.setId(id);
        LOG.info("update {} for Menu {} of Restaurant ", id, menuId, restaurantId);
        dishService.update(dish, menuId, restaurantId);
    }

    public Dish create(Dish dish, int menuId, int restaurantId) {
        dish.setId(null);
        LOG.info("create {} for Menu {} of Restaurant ", menuId, restaurantId);
        return dishService.create(dish, menuId, restaurantId);
    }
}
