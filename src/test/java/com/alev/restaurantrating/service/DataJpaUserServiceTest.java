package com.alev.restaurantrating.service;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import static com.alev.restaurantrating.Profiles.DATAJPA;

@ActiveProfiles(DATAJPA)
public class DataJpaUserServiceTest extends AbstractJpaUserServiceTest {
    
//    @Test
//    public void testGetWithMeals() throws Exception {
//        User user = service.getWithVotes(USER_ID);
//        MATCHER.assertEquals(USER, user);
//        ModelTestData.MATCHER.assertCollectionEquals(MealTestData.USER_VOTES, user.getVotes());
//    }

    @Test(expected = UnsupportedOperationException.class)
    //@Test(expected = NotFoundException.class)
    public void testGetWithMealsNotFound() throws Exception {
        service.getWithVotes(1);
    }
}