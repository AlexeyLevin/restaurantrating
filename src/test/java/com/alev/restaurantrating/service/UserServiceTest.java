package com.alev.restaurantrating.service;

import com.alev.restaurantrating.repository.JpaUtil;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import com.alev.restaurantrating.UserTestData.*;
import com.alev.restaurantrating.model.Role;
import com.alev.restaurantrating.model.User;
import com.alev.restaurantrating.util.exceptions.NotFoundException;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static com.alev.restaurantrating.Profiles.DATAJPA;
import static com.alev.restaurantrating.UserTestData.*;

@ActiveProfiles(DATAJPA)
public class UserServiceTest extends AbstractServiceTest {

    @Autowired
    protected UserService service;

    @After
    public void tearDown() throws Exception {
        service.evictCache();
        jpaUtil.clear2ndLevelHibernateCache();
    }

    @Test
    public void testSave() throws Exception {
        TestUser tu = new TestUser(null, "New", "new@gmail.com", "newPass", false, Collections.singleton(Role.ROLE_USER));
        User created = service.save(tu.asUser());
        tu.setId(created.getId());
        MATCHER.assertCollectionEquals(Arrays.asList(ADMIN, tu, USER), service.getAll());
    }

    @Test(expected = DataAccessException.class)
    public void testDuplicateMailSave() throws Exception {
        service.save(new TestUser("Duplicate", "user@yandex.ru", "newPass", Role.ROLE_USER).asUser());
    }

    @Test
    public void testDelete() throws Exception {
        service.delete(USER_ID);
        MATCHER.assertCollectionEquals(Collections.singletonList(ADMIN), service.getAll());
    }

    @Test(expected = NotFoundException.class)
    public void testNotFoundDelete() throws Exception {
        service.delete(1);
    }

    @Test
    public void testGet() throws Exception {
        User user = service.get(USER_ID);
        MATCHER.assertEquals(USER, user);
    }

    @Test(expected = NotFoundException.class)
    public void testGetNotFound() throws Exception {
        service.get(1);
    }

    @Test
    public void testGetByEmail() throws Exception {
        User user = service.getByEmail("user@yandex.ru");
        MATCHER.assertEquals(USER, user);
    }

    @Test
    public void testGetAll() throws Exception {
        Collection<User> all = service.getAll();
        MATCHER.assertCollectionEquals(Arrays.asList(ADMIN, USER), all);
    }

    @Test
    public void testUpdate() throws Exception {
        TestUser updated = new TestUser(USER);
        updated.setName("UpdatedName");
        updated.setRoles(Arrays.asList(Role.ROLE_ADMIN, Role.ROLE_USER));
        service.update(updated.asUser());
        MATCHER.assertEquals(updated, service.get(USER_ID));
    }

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private JpaUtil jpaUtil;

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