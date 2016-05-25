package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.Dish;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Collection;

import static com.alev.restaurantrating.ModelTestData.*;
import static com.alev.restaurantrating.Profiles.DATAJPA;

@ActiveProfiles(DATAJPA)
public class DishServiceTest extends AbstractServiceTest {

    @Autowired
    protected DishService service;

    @Test
    public void testSave() {
        Dish dish = new Dish("New dish", 20.9f);
        Dish created = service.save(dish, RESTAURANT_1_MENU_ID);
        dish.setId(created.getId());
        Collection<Dish> expectDishes = new ArrayList<>(DISH_LIST_1);
        expectDishes.add(created);
        DISH_MATCHER.assertCollectionEquals(expectDishes, service.getAll(RESTAURANT_1_MENU_ID));
    }

//    @Test
//    public void testDelete() {
//        Collection<Dish> dishes = DISH_LIST_1;
//        dishes.remove();
//        service.delete(1, RESTAURANT_1_MENU_ID);
//        assertTrue(service.getAll(RESTAURANT_1_MENU_ID).isEmpty());
//    }
//
//    @Test
//    public void testGet() {
//        Dish actual = service.get(RESTAURANT_2_MENU_ID, RESTAURANT_2_ID);
//        DISH_MATCHER.assertEquals(RESTAURANT_2_MENU, actual);
//    }
//
//    @Test
//    public void testFindByName() {
//        Dish actual = service.findByName("Ragnarok menu");
//        DISH_MATCHER.assertEquals(RESTAURANT_2_MENU, actual);
//    }
//
//    @Test
//    public void testUpdate() {
//        Dish updated = new Dish(RESTAURANT_1_MENU_ID, RESTAURANT_1_NAME + " обновленный", LocalDate.now());
//        service.update(updated, RESTAURANT_1_ID);
//        DISH_MATCHER.assertEquals(updated, service.get(RESTAURANT_1_MENU_ID, RESTAURANT_1_ID));
//    }
//
//    @Test
//    public void testGetAll() {
//        Dish dish = new Dish(RESTAURANT_1_NAME + " обновленный", LocalDate.now());
//        service.save(dish, RESTAURANT_1_ID);
//        DISH_MATCHER.assertCollectionEquals(Arrays.asList(RESTAURANT_1_MENU, dish), service.getAll(RESTAURANT_1_ID));
//    }
//
//    @Test
//    public void testGetWithRestaurant() {
//        Dish dish = service.getWithRestaurant(RESTAURANT_2_MENU_ID, RESTAURANT_2_ID);
//        Restaurant restaurant = dish.getRestaurant();
//        RESTAURANT_MATCHER.assertEquals(RESTAURANT_2, restaurant);
//    }
//
//    @Test
//    public void testWithDishes() {
//        Dish withDishes = service.getWithDishes(RESTAURANT_1_MENU_ID);
//        DISH_MATCHER.assertEquals(RESTAURANT_1_MENU ,withDishes);
//        DISH_MATCHER.assertCollectionEquals(DISH_LIST_1, withDishes.getDishes());
//    }

}
