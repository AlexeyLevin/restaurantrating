package com.alev.restaurantrating.web.json;

import com.alev.restaurantrating.model.Dish;
import com.alev.restaurantrating.util.json.JsonUtil;
import org.junit.Test;

import static com.alev.restaurantrating.ModelTestData.*;

/**
 * GKislin
 * 22.07.2015.
 */
public class JsonUtilTest {

    @Test
    public void testReadWriteValue() throws Exception {
        String json = JsonUtil.writeValue(DISH_1_MENU_1);
        System.out.println(json);
        Dish dish = JsonUtil.readValue(json, Dish.class);
        DISH_MATCHER.assertEquals(DISH_1_MENU_1, dish);
    }

    @Test
    public void testReadWriteValues() throws Exception {
        String json = JsonUtil.writeValue(DISH_1_MENU_2);
        System.out.println(json);
        Dish dish = JsonUtil.readValue(json, Dish.class);
        DISH_MATCHER.assertEquals(DISH_1_MENU_2, dish);
    }
}