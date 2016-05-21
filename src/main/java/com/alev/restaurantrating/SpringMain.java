package com.alev.restaurantrating;

import com.alev.restaurantrating.model.Role;
import com.alev.restaurantrating.model.User;
import com.alev.restaurantrating.web.user.AdminRestController;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * User: gkislin
 * Date: 22.08.2014
 */
public class SpringMain {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
//            System.out.println(Arrays.toString(appCtx.getBeanDefinitionNames()));
//            UserRepository userRepository = appCtx.getBean(UserRepository.class);
//            userRepository.getAll();
//            UserService userService = appCtx.getBean(UserService.class);
//            System.out.println(userService.save(new User(1, "userName", "email", "password", Role.ROLE_ADMIN)));

            System.out.println(Arrays.toString(appCtx.getBeanDefinitionNames()));
            AdminRestController adminUserController = appCtx.getBean(AdminRestController.class);
            System.out.println(adminUserController.create(new User(1, "userName", "email", "password", Role.ROLE_ADMIN)));
        }
    }
}
