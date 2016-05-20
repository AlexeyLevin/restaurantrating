package com.alev.restaurantrating;

import com.alev.restaurantrating.model.Dish;
import com.alev.restaurantrating.model.LunchMenu;
import com.alev.restaurantrating.model.Restaurant;
import com.alev.restaurantrating.model.Vote;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class ModelTestData {

    private ModelTestData() {
    }

    public static final List<Dish> DISH_LIST_1 = Arrays.asList(
            new Dish("Barbados soup", new BigDecimal(2)),
            new Dish("Barbados salad", new BigDecimal(0.5)),
            new Dish("Barbados meat", new BigDecimal(2.5)),
            new Dish("Barbados coffee", new BigDecimal(0.2))
    );

    public static final List<Dish> DISH_LIST_2 = Arrays.asList(
            new Dish("Ragnarok soup", new BigDecimal(1.5)),
            new Dish("Ragnarok salad", new BigDecimal(0.3)),
            new Dish("Ragnarok meat", new BigDecimal(2)),
            new Dish("Ragnarok coffee", new BigDecimal(0.1))
    );

    public static final List<Dish> DISH_LIST_3 = Arrays.asList(
            new Dish("Saran soup", new BigDecimal(1.5)),
            new Dish("Saran salad", new BigDecimal(0.3)),
            new Dish("Saran meat", new BigDecimal(2)),
            new Dish("Saran coffee", new BigDecimal(0.1))
    );

    public static final LunchMenu LUNCH_MENU_1 = new LunchMenu("Barbados menu", DISH_LIST_1);
    public static final LunchMenu LUNCH_MENU_2 = new LunchMenu("Ragnarok menu", DISH_LIST_2);
    public static final LunchMenu LUNCH_MENU_3 = new LunchMenu("Saran menu", DISH_LIST_3);

    public static final Restaurant TEST_RESTAURANT_1 = new Restaurant("Barbados", LUNCH_MENU_1);
    public static final Restaurant TEST_RESTAURANT_2 = new Restaurant("Ragnarok", LUNCH_MENU_2);
    public static final Restaurant TEST_RESTAURANT_3 = new Restaurant("Saran", LUNCH_MENU_3);

    public static final List<Vote> USER_VOTE_LIST = Arrays.asList(
            new Vote(LocalDateTime.of(2016, Month.MAY, 29, 10, 0), TEST_RESTAURANT_1, LUNCH_MENU_1, true),
            new Vote(LocalDateTime.of(2016, Month.MAY, 30, 10, 0), TEST_RESTAURANT_2, LUNCH_MENU_2, true),
            new Vote(LocalDateTime.of(2016, Month.MAY, 31, 10, 0), TEST_RESTAURANT_3, LUNCH_MENU_3, true)
    );

    public static final List<Vote> ADMIN_VOTE_LIST = Arrays.asList(
            new Vote(LocalDateTime.of(2016, Month.MAY, 29, 10, 0), TEST_RESTAURANT_3, LUNCH_MENU_3, true),
            new Vote(LocalDateTime.of(2016, Month.MAY, 30, 10, 0), TEST_RESTAURANT_2, LUNCH_MENU_2, true),
            new Vote(LocalDateTime.of(2016, Month.MAY, 31, 10, 0), TEST_RESTAURANT_1, LUNCH_MENU_1, true)
    );
}
