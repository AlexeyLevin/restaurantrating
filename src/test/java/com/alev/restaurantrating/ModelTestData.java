package com.alev.restaurantrating;

import com.alev.restaurantrating.model.Dish;
import com.alev.restaurantrating.model.LunchMenu;
import com.alev.restaurantrating.model.Restaurant;
import com.alev.restaurantrating.model.Vote;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static com.alev.restaurantrating.model.BaseEntity.START_SEQ;

public class ModelTestData {

    public static final int BARBADOS_ID = START_SEQ + 2;
    public static final int RAGNAROK_ID = START_SEQ + 3;
    public static final int SARAN_ID = START_SEQ + 4;
    public static final int BARBADOS_DISH_ID = START_SEQ + 5;
    public static final int RAGNAROK_DISH_ID = START_SEQ + 6;
    public static final int SARAN_DISH_ID = START_SEQ + 7;

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

    public static final Restaurant TEST_RESTAURANT_1 = new Restaurant(BARBADOS_ID, "Barbados");
    public static final Restaurant TEST_RESTAURANT_2 = new Restaurant(RAGNAROK_ID,"Ragnarok");
    public static final Restaurant TEST_RESTAURANT_3 = new Restaurant(SARAN_ID, "Saran");

    public static final LunchMenu LUNCH_MENU_1 = new LunchMenu(BARBADOS_DISH_ID, "Barbados menu",  LocalDate.of(2016, Month.MAY, 29));
    public static final LunchMenu LUNCH_MENU_2 = new LunchMenu(RAGNAROK_DISH_ID, "Ragnarok menu", LocalDate.of(2016, Month.MAY, 30));
    public static final LunchMenu LUNCH_MENU_3 = new LunchMenu(SARAN_DISH_ID, "Saran menu", LocalDate.of(2016, Month.MAY, 31));

    public static final List<Vote> USER_VOTE_LIST = Arrays.asList(
            new Vote(LocalDate.of(2016, Month.MAY, 29), TEST_RESTAURANT_1, LUNCH_MENU_1, true),
            new Vote(LocalDate.of(2016, Month.MAY, 30), TEST_RESTAURANT_2, LUNCH_MENU_2, true),
            new Vote(LocalDate.of(2016, Month.MAY, 31), TEST_RESTAURANT_3, LUNCH_MENU_3, true)
    );

    public static final List<Vote> ADMIN_VOTE_LIST = Arrays.asList(
            new Vote(LocalDate.of(2016, Month.MAY, 29), TEST_RESTAURANT_3, LUNCH_MENU_3, true),
            new Vote(LocalDate.of(2016, Month.MAY, 30), TEST_RESTAURANT_2, LUNCH_MENU_2, true),
            new Vote(LocalDate.of(2016, Month.MAY, 31), TEST_RESTAURANT_1, LUNCH_MENU_1, true)
    );
}
