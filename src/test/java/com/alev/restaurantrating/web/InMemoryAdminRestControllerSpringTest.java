package com.alev.restaurantrating.web;

import com.alev.restaurantrating.UserTestData;
import com.alev.restaurantrating.model.User;
import com.alev.restaurantrating.repository.UserRepository;
import com.alev.restaurantrating.util.exceptions.NotFoundException;
import com.alev.restaurantrating.web.user.AdminRestController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

import static com.alev.restaurantrating.UserTestData.ADMIN;
import static com.alev.restaurantrating.UserTestData.USER;

@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/mock.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class InMemoryAdminRestControllerSpringTest {

    @Autowired
    private AdminRestController controller;

    @Autowired
    private UserRepository repository;

    @Before
    public void setUp() throws Exception {
        repository.getAll().forEach(u -> repository.delete(u.getId()));
        repository.save(USER);
        repository.save(ADMIN);
    }

    @Test
    public void testDelete() throws Exception {
        controller.delete(UserTestData.USER_ID);
        Collection<User> users = controller.getAll();
        Assert.assertEquals(users.size(), 1);
        Assert.assertEquals(users.iterator().next(), ADMIN);
    }

    @Test(expected = NotFoundException.class)
    public void testDeleteNotFound() throws Exception {
        controller.delete(10);
    }
}
