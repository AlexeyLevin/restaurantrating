package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.Menu;
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
        Menu menu = new Menu("New menu", LocalDate.now());
        Menu created = service.save(menu, RESTAURANT_1_ID);
        menu.setId(created.getId());
        MENU_MATCHER.assertCollectionEquals(Arrays.asList(created, RESTAURANT_1_MENU), service.getAll(RESTAURANT_1_ID));
    }

    @Test
    public void testDelete() {
        service.delete(RESTAURANT_1_MENU_ID, RESTAURANT_1_ID);
        assertTrue(service.getAll(RESTAURANT_1_ID).isEmpty());
    }

    @Test
    public void testGet() {
        Menu actual = service.get(RESTAURANT_2_MENU_ID, RESTAURANT_2_ID);
        MENU_MATCHER.assertEquals(RESTAURANT_2_MENU, actual);
    }

    @Test
    public void testFindByName() {
        Menu actual = service.findByName(RESTAURANT_2_NAME + STRING_MENU);
        MENU_MATCHER.assertEquals(RESTAURANT_2_MENU, actual);
    }

    @Test
    public void testUpdate() {
        Menu updated = new Menu(RESTAURANT_1_MENU_ID, RESTAURANT_1_NAME + " new", LocalDate.now());
        service.update(updated, RESTAURANT_1_ID);
        MENU_MATCHER.assertEquals(updated, service.get(RESTAURANT_1_MENU_ID, RESTAURANT_1_ID));
    }

    @Test
    public void testGetAll() {
        Menu menu = new Menu(RESTAURANT_1_NAME + " new", LocalDate.now());
        service.save(menu, RESTAURANT_1_ID);
        MENU_MATCHER.assertCollectionEquals(Arrays.asList(menu, RESTAURANT_1_MENU), service.getAll(RESTAURANT_1_ID));
    }

    @Test
    public void testGetWithRestaurant() {
        Menu menu = service.getWithRestaurant(RESTAURANT_2_MENU_ID, RESTAURANT_2_ID);
        Restaurant restaurant = menu.getRestaurant();
        RESTAURANT_MATCHER.assertEquals(RESTAURANT_2, restaurant);
    }

    @Test
    public void testWithDishes() {
        Menu withDishes = service.getWithDishes(RESTAURANT_1_MENU_ID);
        MENU_MATCHER.assertEquals(RESTAURANT_1_MENU ,withDishes);
        DISH_MATCHER.assertCollectionEquals(DISH_LIST_1, withDishes.getDishes());
    }
}