package com.alev.restaurantrating.model;

import java.time.LocalDate;
import java.util.Set;

public class LunchMenu {
    private int restaurant_id;
    private LocalDate menuDate;
    private Set<Dish> dishList;
}
