package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.Restaurant;
import com.alev.restaurantrating.util.exceptions.NotFoundException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.Collection;

import static com.alev.restaurantrating.ModelTestData.*;

public class RestaurantServiceTest extends AbstractServiceTest {

    @Autowired
    protected RestaurantService service;

    @Test
    public void testSave() throws Exception {
        Restaurant restaurant = new Restaurant(null, "New restaurant");
        Restaurant created = service.save(restaurant);
        restaurant.setId(created.getId());
        RESTAURANT_MATCHER.assertCollectionEquals(Arrays.asList(RESTAURANT_1, restaurant, RESTAURANT_2, RESTAURANT_3), service.getAll());
    }

    @Test(expected = DataAccessException.class)
    public void testDuplicateMailSave() throws Exception {
        service.save(new Restaurant(null, RESTAURANT_1_NAME));
    }

    @Test
    public void testDelete() throws Exception {
        service.delete(RESTAURANT_1_ID);
        RESTAURANT_MATCHER.assertCollectionEquals(Arrays.asList(RESTAURANT_2, RESTAURANT_3), service.getAll());
    }

    @Test(expected = NotFoundException.class)
    public void testNotFoundDelete() throws Exception {
        service.delete(1);
    }

    @Test
    public void testGet() throws Exception {
        Restaurant restaurant = service.get(RESTAURANT_1_ID);
        RESTAURANT_MATCHER.assertEquals(RESTAURANT_1, restaurant);
    }

    @Test(expected = NotFoundException.class)
    public void testGetNotFound() throws Exception {
        service.get(1);
    }

    @Test
    public void testFindByName() throws Exception {
        Restaurant restaurant = service.findByName(RESTAURANT_1_NAME);
        RESTAURANT_MATCHER.assertEquals(RESTAURANT_1, restaurant);
    }

    @Test
    public void testGetAll() throws Exception {
        Collection<Restaurant> all = service.getAll();
        RESTAURANT_MATCHER.assertCollectionEquals(Arrays.asList(RESTAURANT_1, RESTAURANT_2, RESTAURANT_3), all);
    }

    @Test
    public void testUpdate() throws Exception {
        Restaurant updated = new Restaurant(RESTAURANT_1);
        updated.setName("UpdatedName");
        service.update(updated);
        RESTAURANT_MATCHER.assertEquals(updated, service.get(RESTAURANT_1_ID));
    }
}
