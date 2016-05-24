package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.LunchMenu;
import com.alev.restaurantrating.model.Restaurant;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.Arrays;

import static com.alev.restaurantrating.ModelTestData.*;
import static com.alev.restaurantrating.Profiles.DATAJPA;
import static org.junit.Assert.assertTrue;

@ActiveProfiles(DATAJPA)
public class MenuServiceTest extends AbstractServiceTest {

    @Autowired
    protected MenuService service;

    @Test
    public void testSave() {
        LunchMenu lunchMenu = new LunchMenu("New menu", LocalDate.now());
        LunchMenu created = service.save(lunchMenu, RESTAURANT_1_ID);
        lunchMenu.setId(created.getId());
        MENU_MATCHER.assertCollectionEquals(Arrays.asList(RESTAURANT_1_MENU, created), service.getAll(RESTAURANT_1_ID));
    }

    @Test
    public void testDelete() {
        service.delete(RESTAURANT_1_MENU_ID, RESTAURANT_1_ID);
        assertTrue(service.getAll(RESTAURANT_1_ID).isEmpty());
    }

    @Test
    public void testGet() {
        LunchMenu actual = service.get(RESTAURANT_2_MENU_ID, RESTAURANT_2_ID);
        MENU_MATCHER.assertEquals(RESTAURANT_2_MENU, actual);
    }

    @Test
    public void testGetByName() {
        LunchMenu actual = service.getByName("Ragnarok menu");
        MENU_MATCHER.assertEquals(RESTAURANT_2_MENU, actual);
    }

    @Test
    public void testUpdate() {
        LunchMenu updated = new LunchMenu(RESTAURANT_1_MENU_ID, RESTAURANT_1_NAME + " обновленный", LocalDate.now());
        service.update(updated, RESTAURANT_1_ID);
        MENU_MATCHER.assertEquals(updated, service.get(RESTAURANT_1_MENU_ID, RESTAURANT_1_ID));
    }

    @Test
    public void testGetAll() {
        LunchMenu lunchMenu = new LunchMenu(RESTAURANT_1_NAME + " обновленный", LocalDate.now());
        service.save(lunchMenu, RESTAURANT_1_ID);
        MENU_MATCHER.assertCollectionEquals(Arrays.asList(RESTAURANT_1_MENU, lunchMenu), service.getAll(RESTAURANT_1_ID));
    }

    @Test
    public void testGetWithRestaurant() {
        LunchMenu lunchMenu = service.getWithRestaurant(RESTAURANT_2_MENU_ID, RESTAURANT_2_ID);
        Restaurant restaurant = lunchMenu.getRestaurant();
        RESTAURANT_MATCHER.assertEquals(RESTAURANT_2, restaurant);
    }

    @Test
    public void testWithDishes() {
        LunchMenu withDishes = service.getWithDishes(RESTAURANT_1_MENU_ID);
        MENU_MATCHER.assertEquals(RESTAURANT_1_MENU ,withDishes);
        DISH_MATCHER.assertCollectionEquals(DISH_LIST_1, withDishes.getDishes());
    }
}