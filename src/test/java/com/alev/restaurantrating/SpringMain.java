package com.alev.restaurantrating;

import com.alev.restaurantrating.web.user.AdminRestController;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext()) {
            appCtx.getEnvironment().setActiveProfiles(Profiles.ACTIVE_DB);
            appCtx.load("spring/spring-app.xml", "spring/spring-db.xml", "spring/spring-mvc.xml");
            appCtx.refresh();

            System.out.println(Arrays.toString(appCtx.getBeanDefinitionNames()));
            AdminRestController adminUserController = appCtx.getBean(AdminRestController.class);
            System.out.println(adminUserController.get(UserTestData.USER_ID));
            System.out.println();
        }
    }
}
