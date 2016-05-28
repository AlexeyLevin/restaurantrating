package com.alev.restaurantrating;

import com.alev.restaurantrating.matcher.ModelMatcher;
import com.alev.restaurantrating.model.Dish;
import com.alev.restaurantrating.model.Menu;
import com.alev.restaurantrating.model.Restaurant;
import com.alev.restaurantrating.model.Vote;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.alev.restaurantrating.TestUtil.ToStringModelMatcher;
import static com.alev.restaurantrating.UserTestData.ADMIN;
import static com.alev.restaurantrating.UserTestData.USER;
import static com.alev.restaurantrating.model.BaseEntity.START_SEQ;

public class ModelTestData {
    public static final int RESTAURANT_1_ID = START_SEQ + 2;
    public static final int RESTAURANT_2_ID = START_SEQ + 3;
    public static final int RESTAURANT_3_ID = START_SEQ + 4;
    public static final int RESTAURANT_1_MENU_ID = START_SEQ + 5;
    public static final int RESTAURANT_2_MENU_ID = START_SEQ + 6;
    public static final int RESTAURANT_3_MENU_ID = START_SEQ + 7;
    public static final int DISH_1_MENU_1_ID = START_SEQ + 8;
    public static final int DISH_2_MENU_1_ID = START_SEQ + 9;
    public static final int DISH_3_MENU_1_ID = START_SEQ + 10;
    public static final int DISH_4_MENU_1_ID = START_SEQ + 11;
    public static final int DISH_1_MENU_2_ID = START_SEQ + 12;
    public static final int DISH_2_MENU_2_ID = START_SEQ + 13;
    public static final int DISH_3_MENU_2_ID = START_SEQ + 14;
    public static final int DISH_4_MENU_2_ID = START_SEQ + 15;
    public static final int DISH_1_MENU_3_ID = START_SEQ + 16;
    public static final int DISH_2_MENU_3_ID = START_SEQ + 17;
    public static final int DISH_3_MENU_3_ID = START_SEQ + 18;
    public static final int DISH_4_MENU_3_ID = START_SEQ + 19;
    public static final int USER_VOTE_1_ID = START_SEQ + 20;
    public static final int USER_VOTE_2_ID = START_SEQ + 21;
    public static final int ADMIN_VOTE_1_ID = START_SEQ + 22;
    public static final int ADMIN_VOTE_2_ID = START_SEQ + 23;

    public static final String RESTAURANT_1_NAME = "Barbados";
    public static final String RESTAURANT_2_NAME = "Ragnarok";
    public static final String RESTAURANT_3_NAME = "Saran";
    public static final String STRING_MENU = " menu";
    public static final String STRING_SOUP = " soup";
    public static final String STRING_SALAD = " salad";
    public static final String STRING_MEAT = " meat";
    public static final String STRING_COFFEE = " coffee";

    public static final LocalDate VOTE_DAY = LocalDate.of(2015, Month.MAY, 30);
    public static final LocalDate NEXT_VOTE_DAY = LocalDate.of(2015, Month.MAY, 31);

    public static final Restaurant RESTAURANT_1 = new Restaurant(RESTAURANT_1_ID, RESTAURANT_1_NAME);
    public static final Restaurant RESTAURANT_2 = new Restaurant(RESTAURANT_2_ID, RESTAURANT_2_NAME);
    public static final Restaurant RESTAURANT_3 = new Restaurant(RESTAURANT_3_ID, RESTAURANT_3_NAME);

    public static final Menu RESTAURANT_1_MENU = new Menu(RESTAURANT_1_MENU_ID, RESTAURANT_1_NAME + STRING_MENU, VOTE_DAY);
    public static final Menu RESTAURANT_2_MENU = new Menu(RESTAURANT_2_MENU_ID, RESTAURANT_2_NAME + STRING_MENU, VOTE_DAY);
    public static final Menu RESTAURANT_3_MENU = new Menu(RESTAURANT_3_MENU_ID, RESTAURANT_3_NAME + STRING_MENU, NEXT_VOTE_DAY);

    public static final Dish DISH_1_MENU_1 = new Dish(DISH_1_MENU_1_ID, RESTAURANT_1_NAME + STRING_SOUP, 2f);
    public static final Dish DISH_2_MENU_1 = new Dish(DISH_2_MENU_1_ID, RESTAURANT_1_NAME + STRING_SALAD, 0.5f);
    public static final Dish DISH_3_MENU_1 = new Dish(DISH_3_MENU_1_ID, RESTAURANT_1_NAME + STRING_MEAT, 2.5f);
    public static final Dish DISH_4_MENU_1 = new Dish(DISH_4_MENU_1_ID, RESTAURANT_1_NAME + STRING_COFFEE, 0.2f);

    public static final Dish DISH_1_MENU_2 = new Dish(DISH_1_MENU_2_ID, RESTAURANT_2_NAME + STRING_SOUP, 1.5f);
    public static final Dish DISH_2_MENU_2 = new Dish(DISH_2_MENU_2_ID, RESTAURANT_2_NAME + STRING_SALAD, 0.3f);
    public static final Dish DISH_3_MENU_2 = new Dish(DISH_3_MENU_2_ID, RESTAURANT_2_NAME + STRING_MEAT, 2f);
    public static final Dish DISH_4_MENU_2 = new Dish(DISH_4_MENU_2_ID, RESTAURANT_2_NAME + STRING_COFFEE, 0.1f);

    public static final Dish DISH_1_MENU_3 = new Dish(DISH_1_MENU_3_ID, RESTAURANT_3_NAME + STRING_SOUP, 1.5f);
    public static final Dish DISH_2_MENU_3 = new Dish(DISH_2_MENU_3_ID, RESTAURANT_3_NAME + STRING_SALAD, 0.3f);
    public static final Dish DISH_3_MENU_3 = new Dish(DISH_3_MENU_3_ID, RESTAURANT_3_NAME + STRING_MEAT, 2f);
    public static final Dish DISH_4_MENU_3 = new Dish(DISH_4_MENU_3_ID, RESTAURANT_3_NAME + STRING_COFFEE, 0.1f);

    public static final Vote USER_VOTE_1 = new Vote(USER_VOTE_1_ID, USER, VOTE_DAY, RESTAURANT_1, RESTAURANT_1_MENU);
    public static final Vote USER_VOTE_2 = new Vote(USER_VOTE_2_ID, USER, NEXT_VOTE_DAY, RESTAURANT_2, RESTAURANT_2_MENU);
    public static final Vote ADMIN_VOTE_1 = new Vote(ADMIN_VOTE_1_ID, ADMIN, VOTE_DAY, RESTAURANT_2, RESTAURANT_2_MENU);
    public static final Vote ADMIN_VOTE_2 = new Vote(ADMIN_VOTE_2_ID, ADMIN, NEXT_VOTE_DAY, RESTAURANT_3, RESTAURANT_3_MENU);

    public static final ModelMatcher<Restaurant, String> RESTAURANT_MATCHER = new ToStringModelMatcher<>(Restaurant.class);
    public static final ModelMatcher<Menu, String> MENU_MATCHER = new ToStringModelMatcher<>(Menu.class);
    public static final ModelMatcher<Dish, String> DISH_MATCHER = new ToStringModelMatcher<>(Dish.class);
    public static final ModelMatcher<Vote, String> VOTE_MATCHER = new ToStringModelMatcher<>(Vote.class);

    public static final List<Dish> DISH_LIST_1 = new ArrayList<>(Arrays.asList(DISH_1_MENU_1, DISH_2_MENU_1, DISH_3_MENU_1, DISH_4_MENU_1));
    public static final List<Dish> DISH_LIST_2 = new ArrayList<>(Arrays.asList(DISH_4_MENU_2, DISH_3_MENU_2, DISH_2_MENU_2, DISH_1_MENU_2));
    public static final List<Dish> DISH_LIST_3 = new ArrayList<>(Arrays.asList(DISH_1_MENU_3, DISH_2_MENU_3, DISH_3_MENU_3, DISH_4_MENU_3));

    public static final List<Vote> USER_VOTE_LIST = Arrays.asList(USER_VOTE_1, USER_VOTE_2);
    public static final List<Vote> ADMIN_VOTE_LIST = Arrays.asList(ADMIN_VOTE_1, ADMIN_VOTE_2);

    private ModelTestData() {
    }
}
