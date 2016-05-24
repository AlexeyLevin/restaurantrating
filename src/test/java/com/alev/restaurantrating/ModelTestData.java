package com.alev.restaurantrating;

import com.alev.restaurantrating.matcher.ModelMatcher;
import com.alev.restaurantrating.model.Dish;
import com.alev.restaurantrating.model.LunchMenu;
import com.alev.restaurantrating.model.Restaurant;
import com.alev.restaurantrating.model.Vote;

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
    public static final ModelMatcher<Dish, String> DISH_MATCHER = new ToStringModelMatcher<>(Dish.class);

    private ModelTestData() {
    }

    public static final List<Dish> DISH_LIST_1 = Arrays.asList(
            new Dish(100008, RESTAURANT_1_NAME + " soup", 2f),
            new Dish(100009, RESTAURANT_1_NAME + " salad", 0.5f),
            new Dish(100010, RESTAURANT_1_NAME + " meat", 2.5f),
            new Dish(100011, RESTAURANT_1_NAME + " coffee", 0.2f)
    );

    public static final List<Dish> DISH_LIST_2 = Arrays.asList(
            new Dish(100012, RESTAURANT_2_NAME + " soup", 1.5f),
            new Dish(100013, RESTAURANT_2_NAME + " salad", 0.3f),
            new Dish(100014, RESTAURANT_2_NAME + " meat", 2f),
            new Dish(100015, RESTAURANT_2_NAME + " coffee", 0.1f)
    );

    public static final List<Dish> DISH_LIST_3 = Arrays.asList(
            new Dish(100016, RESTAURANT_3_NAME + " soup", 1.5f),
            new Dish(100017, RESTAURANT_3_NAME + " salad", 0.3f),
            new Dish(100018, RESTAURANT_3_NAME + " meat", 2f),
            new Dish(100019, RESTAURANT_3_NAME + " coffee", 0.1f)
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
