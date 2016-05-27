package com.alev.restaurantrating.web.json;

import com.alev.restaurantrating.UserTestData;
import com.alev.restaurantrating.model.User;
import org.junit.Test;

/**
 * GKislin
 * 22.07.2015.
 */
public class JsonUtilTest {

    @Test
    public void testReadWriteValue() throws Exception {
        String json = JsonUtil.writeValue(UserTestData.USER);
        System.out.println(json);
        User user = JsonUtil.readValue(json, User.class);
        UserTestData.USER_MATCHER.assertEquals(UserTestData.USER, user);
    }

    @Test
    public void testReadWriteValues() throws Exception {
        String json = JsonUtil.writeValue(UserTestData.ADMIN);
        System.out.println(json);
        User adminJson = JsonUtil.readValue(json, User.class);
        UserTestData.USER_MATCHER.assertEquals(UserTestData.ADMIN, adminJson);
    }
}