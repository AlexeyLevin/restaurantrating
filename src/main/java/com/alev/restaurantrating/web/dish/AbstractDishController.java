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

    public Dish get(int id, int menuId) {
        LOG.info("get dish {} for Menu {}", id, menuId);
        return dishService.get(id, menuId);
    }

    public Dish getWithMenu(int id, int menuId)  {
        LOG.info("getWithMenu {} for Menu {}", id, menuId);
        return dishService.getWithMenu(id, menuId);
    }

    public void delete(int id, int menuId) {
        LOG.info("delete dish {} for Menu {}", id, menuId);
        dishService.delete(id, menuId);
    }

    public Collection<Dish> getAll(int menuId) {
        LOG.info("getAll for Menu {}", menuId);
        return dishService.getAll(menuId);
    }

    public void update(Dish dish, int id, int menuId) {
        dish.setId(id);
        LOG.info("update {} for Menu {}", dish, menuId);
        dishService.update(dish, menuId);
    }

    public Dish create(Dish dish, int menuId) {
        dish.setId(null);
        LOG.info("create {} for Menu {}", dish, menuId);
        return dishService.save(dish, menuId);
    }
}
