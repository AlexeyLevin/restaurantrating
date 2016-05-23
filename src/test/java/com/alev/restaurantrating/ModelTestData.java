package com.alev.restaurantrating;

import com.alev.restaurantrating.matcher.ModelMatcher;
import com.alev.restaurantrating.model.Dish;
import com.alev.restaurantrating.model.LunchMenu;
import com.alev.restaurantrating.model.Restaurant;
import com.alev.restaurantrating.model.Vote;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static com.alev.restaurantrating.TestUtil.ToStringModelMatcher;
import static com.alev.restaurantrating.model.BaseEntity.START_SEQ;

public class ModelTestData {

    public static final int RESTAURANT_1_ID = START_SEQ + 2;
    public static final int RESTAURANT_2_ID = START_SEQ + 3;
    public static final int RESTAURANT_3_ID = START_SEQ + 4;
    public static final int RESTAURANT_1_MENU_ID = START_SEQ + 5;
    public static final int RESTAURANT_2_MENU_ID = START_SEQ + 6;
    public static final int RESTAURANT_3_MENU_ID = START_SEQ + 7;
    public static final String RESTAURANT_1_NAME = "Barbados";
    public static final String RESTAURANT_2_NAME = "Ragnarok";
    public static final String RESTAURANT_3_NAME = "Saran";
    public static final LocalDate VOTE_DAY = LocalDate.of(2016, Month.MAY, 30);
    public static final LocalDate NEXT_VOTE_DAY = LocalDate.of(2016, Month.MAY, 31);
    public static final ModelMatcher<Restaurant, String> RESTAURANT_MATCHER = new ToStringModelMatcher<>(Restaurant.class);
    public static final ModelMatcher<LunchMenu, String> MENU_MATCHER = new ToStringModelMatcher<>(LunchMenu.class);


    private ModelTestData() {
    }

    public static final List<Dish> DISH_LIST_1 = Arrays.asList(
            new Dish(RESTAURANT_1_NAME + " soup", new BigDecimal(2)),
            new Dish(RESTAURANT_1_NAME + " salad", new BigDecimal(0.5)),
            new Dish(RESTAURANT_1_NAME + " meat", new BigDecimal(2.5)),
            new Dish(RESTAURANT_1_NAME + " coffee", new BigDecimal(0.2))
    );

    public static final List<Dish> DISH_LIST_2 = Arrays.asList(
            new Dish(RESTAURANT_2_NAME + " soup", new BigDecimal(1.5)),
            new Dish(RESTAURANT_2_NAME + " salad", new BigDecimal(0.3)),
            new Dish(RESTAURANT_2_NAME + " meat", new BigDecimal(2)),
            new Dish(RESTAURANT_2_NAME + " coffee", new BigDecimal(0.1))
    );

    public static final List<Dish> DISH_LIST_3 = Arrays.asList(
            new Dish(RESTAURANT_3_NAME + " soup", new BigDecimal(1.5)),
            new Dish(RESTAURANT_3_NAME + " salad", new BigDecimal(0.3)),
            new Dish(RESTAURANT_3_NAME + " meat", new BigDecimal(2)),
            new Dish(RESTAURANT_3_NAME + " coffee", new BigDecimal(0.1))
    );

    public static final Restaurant RESTAURANT_1 = new Restaurant(RESTAURANT_1_ID, RESTAURANT_1_NAME);
    public static final Restaurant RESTAURANT_2 = new Restaurant(RESTAURANT_2_ID, RESTAURANT_2_NAME);
    public static final Restaurant RESTAURANT_3 = new Restaurant(RESTAURANT_3_ID, RESTAURANT_3_NAME);

    public static final LunchMenu RESTAURANT_1_MENU = new LunchMenu(RESTAURANT_1_MENU_ID, RESTAURANT_1_NAME + " menu", VOTE_DAY);
    public static final LunchMenu RESTAURANT_2_MENU = new LunchMenu(RESTAURANT_2_MENU_ID, RESTAURANT_2_NAME + " menu", VOTE_DAY);
    public static final LunchMenu RESTAURANT_3_MENU = new LunchMenu(RESTAURANT_3_MENU_ID, RESTAURANT_3_NAME + " menu", NEXT_VOTE_DAY);

    public static final List<Vote> USER_VOTE_LIST = Arrays.asList(
            new Vote(VOTE_DAY, RESTAURANT_1, RESTAURANT_1_MENU),
            new Vote(NEXT_VOTE_DAY, RESTAURANT_3, RESTAURANT_3_MENU)
    );

    public static final List<Vote> ADMIN_VOTE_LIST = Arrays.asList(
            new Vote(VOTE_DAY, RESTAURANT_2, RESTAURANT_2_MENU),
            new Vote(NEXT_VOTE_DAY, RESTAURANT_3, RESTAURANT_3_MENU)
    );
}
