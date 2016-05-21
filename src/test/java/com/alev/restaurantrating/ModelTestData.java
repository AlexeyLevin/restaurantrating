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
    public static final int BARBADOS_MENU_ID = START_SEQ + 5;
    public static final int RAGNAROK_MENU_ID = START_SEQ + 6;
    public static final int SARAN_MENU_ID = START_SEQ + 7;
    public static final LocalDate VOTE_DAY = LocalDate.of(2016, Month.MAY, 30);
    public static final LocalDate NEXT_VOTE_DAY = LocalDate.of(2016, Month.MAY, 31);

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
    public static final Restaurant TEST_RESTAURANT_2 = new Restaurant(RAGNAROK_ID, "Ragnarok");
    public static final Restaurant TEST_RESTAURANT_3 = new Restaurant(SARAN_ID, "Saran");

    public static final LunchMenu LUNCH_MENU_1 = new LunchMenu(BARBADOS_MENU_ID, "Barbados menu", VOTE_DAY);
    public static final LunchMenu LUNCH_MENU_2 = new LunchMenu(RAGNAROK_MENU_ID, "Ragnarok menu", VOTE_DAY);
    public static final LunchMenu LUNCH_MENU_3 = new LunchMenu(SARAN_MENU_ID, "Saran menu", NEXT_VOTE_DAY);

    public static final List<Vote> USER_VOTE_LIST = Arrays.asList(
            new Vote(VOTE_DAY, TEST_RESTAURANT_1, LUNCH_MENU_1),
            new Vote(NEXT_VOTE_DAY, TEST_RESTAURANT_3, LUNCH_MENU_3)
    );

    public static final List<Vote> ADMIN_VOTE_LIST = Arrays.asList(
            new Vote(VOTE_DAY, TEST_RESTAURANT_2, LUNCH_MENU_2),
            new Vote(NEXT_VOTE_DAY, TEST_RESTAURANT_3, LUNCH_MENU_3)
    );
}
