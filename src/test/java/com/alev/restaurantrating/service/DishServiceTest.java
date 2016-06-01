package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.Dish;
import com.alev.restaurantrating.model.Menu;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

import static com.alev.restaurantrating.ModelTestData.*;
import static com.alev.restaurantrating.Profiles.DATAJPA;

@ActiveProfiles(DATAJPA)
public class DishServiceTest extends AbstractServiceTest {

    @Autowired
    protected DishService service;

    @Test
    public void testSave() {
        Dish dish = new Dish("New dish", 20.9f);
        Dish created = service.create(dish, RESTAURANT_1_MENU_ID, RESTAURANT_1_ID);
        dish.setId(created.getId());
        DISH_MATCHER.assertCollectionEquals(Arrays.asList(DISH_4_MENU_1, DISH_3_MENU_1, DISH_2_MENU_1, DISH_1_MENU_1, created), service.getAll(RESTAURANT_1_MENU_ID, RESTAURANT_1_ID));
    }

    @Test
    public void testDelete() {
        service.delete(DISH_1_MENU_1_ID, RESTAURANT_1_MENU_ID, RESTAURANT_1_ID);
        DISH_MATCHER.assertCollectionEquals(Arrays.asList(DISH_4_MENU_1, DISH_3_MENU_1, DISH_2_MENU_1), service.getAll(RESTAURANT_1_MENU_ID, RESTAURANT_1_ID));
    }

    @Test
    public void testGet() {
        Dish actual = service.get(DISH_4_MENU_1_ID, RESTAURANT_1_MENU_ID, RESTAURANT_1_ID);
        DISH_MATCHER.assertEquals(DISH_4_MENU_1, actual);
    }

    @Test
    public void testFindByName() {
        Dish actual = service.findByName(RESTAURANT_1_NAME + STRING_COFFEE);
        DISH_MATCHER.assertEquals(DISH_4_MENU_1, actual);
    }

    @Test
    public void testUpdate() {
        Dish updated = new Dish(DISH_3_MENU_1_ID, RESTAURANT_1_NAME + STRING_MEAT + " new meat", 10f);
        service.update(updated, RESTAURANT_1_MENU_ID, RESTAURANT_1_ID);
        DISH_MATCHER.assertEquals(updated, service.get(DISH_3_MENU_1_ID, RESTAURANT_1_MENU_ID, RESTAURANT_1_ID));
    }

    @Test
    public void testGetAll() {
        Dish dish = new Dish(RESTAURANT_1_NAME + STRING_MEAT + " new stuff", 10f);
        service.create(dish, RESTAURANT_1_MENU_ID, RESTAURANT_1_ID);
        DISH_MATCHER.assertCollectionEquals(Arrays.asList(DISH_4_MENU_1, DISH_3_MENU_1, dish, DISH_2_MENU_1, DISH_1_MENU_1), service.getAll(RESTAURANT_1_MENU_ID, RESTAURANT_1_ID));
    }

    @Test
    public void testGetWithMenu() {
        Dish dish = service.getWithMenu(DISH_2_MENU_1_ID, RESTAURANT_1_MENU_ID, RESTAURANT_1_ID);
        Menu menu = dish.getMenu();
        MENU_MATCHER.assertEquals(menu, RESTAURANT_1_MENU);
    }
}
