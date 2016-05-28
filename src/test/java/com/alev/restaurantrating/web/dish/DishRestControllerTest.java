package com.alev.restaurantrating.web.dish;

import com.alev.restaurantrating.model.Dish;
import com.alev.restaurantrating.service.DishService;
import com.alev.restaurantrating.util.json.JsonUtil;
import com.alev.restaurantrating.web.AbstractControllerTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;

import static com.alev.restaurantrating.ModelTestData.*;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DishRestControllerTest extends AbstractControllerTest {
    public static final String REST_URL = AdminRestDishController.REST_URL + '/';

    @Autowired
    private DishService dishService;

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get(REST_URL + DISH_1_MENU_1_ID, RESTAURANT_1_MENU_ID))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(DISH_MATCHER.contentMatcher(DISH_1_MENU_1));
    }

    @Test
    public void testGetNotFound() throws Exception {
        mockMvc.perform(get(REST_URL + DISH_1_MENU_1_ID, RESTAURANT_2_MENU_ID))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDeleteNotFound() throws Exception {
        mockMvc.perform(delete(REST_URL + DISH_1_MENU_3_ID, RESTAURANT_2_MENU_ID))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete(REST_URL + DISH_1_MENU_1_ID, RESTAURANT_1_MENU_ID))
                .andExpect(status().isOk());
        DISH_MATCHER.assertCollectionEquals(Arrays.asList(DISH_4_MENU_1, DISH_3_MENU_1, DISH_2_MENU_1), dishService.getAll(RESTAURANT_1_MENU_ID));
    }

    @Test
    public void testUpdate() throws Exception {
        Dish updated = new Dish(DISH_1_MENU_1_ID, RESTAURANT_1_NAME + STRING_SOUP + " updated", 3f);
        mockMvc.perform(put(REST_URL + DISH_1_MENU_1_ID, RESTAURANT_1_MENU_ID).contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andExpect(status().isOk());
        assertEquals(updated, dishService.get(DISH_1_MENU_1_ID, RESTAURANT_1_MENU_ID));
    }

    @Test
    public void testCreate() throws Exception {
        Dish created = new Dish(RESTAURANT_1_NAME + STRING_SOUP + " updated", 3f);
        ResultActions action = mockMvc.perform(post(REST_URL, RESTAURANT_1_MENU_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(created)));

        Dish returned = DISH_MATCHER.fromJsonAction(action);
        created.setId(returned.getId());

        DISH_MATCHER.assertEquals(created, returned);
        DISH_MATCHER.assertCollectionEquals(Arrays.asList(DISH_4_MENU_1, DISH_3_MENU_1, DISH_2_MENU_1, DISH_1_MENU_1, created), dishService.getAll(RESTAURANT_1_MENU_ID));
    }

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get(REST_URL, RESTAURANT_2_MENU_ID))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(DISH_MATCHER.contentListMatcher(DISH_LIST_2));
    }
}
