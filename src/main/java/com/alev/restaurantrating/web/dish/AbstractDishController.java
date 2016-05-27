package com.alev.restaurantrating.web.dish;

import com.alev.restaurantrating.service.DishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDishController {
    private final Logger LOG = LoggerFactory.getLogger(AbstractDishController.class);

    @Autowired
    private DishService dishService;
}
