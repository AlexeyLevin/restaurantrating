package com.alev.restaurantrating;

import com.alev.restaurantrating.web.user.AdminRestController;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
//            UserRepository userRepository = appCtx.getBean(UserRepository.class);
//            userRepository.getAll();
//            UserService userService = appCtx.getBean(UserService.class);
            System.out.println(Arrays.toString(appCtx.getBeanDefinitionNames()));
            AdminRestController adminUserController = appCtx.getBean(AdminRestController.class);
            System.out.println(adminUserController.create(UserTestData.USER));
            System.out.println();
        }
    }
}
