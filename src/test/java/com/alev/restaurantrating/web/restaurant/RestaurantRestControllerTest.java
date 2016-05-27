package com.alev.restaurantrating.web.restaurant;

import com.alev.restaurantrating.TestUtil;
import com.alev.restaurantrating.model.Restaurant;
import com.alev.restaurantrating.service.RestaurantService;
import com.alev.restaurantrating.util.json.JsonUtil;
import com.alev.restaurantrating.web.AbstractControllerTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;

import static com.alev.restaurantrating.ModelTestData.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RestaurantRestControllerTest extends AbstractControllerTest {

    public static final String REST_URL = RestRestaurantController.REST_URL + '/';

    @Autowired
    private RestaurantService service;

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get(REST_URL + RESTAURANT_1_ID))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(RESTAURANT_MATCHER.contentMatcher(RESTAURANT_1));
    }

//    @Test
//    public void testGetName() throws Exception {
//        mockMvc.perform(get(REST_URL + "by?name=" + RESTAURANT_1.getName()))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(RESTAURANT_MATCHER.contentMatcher(RESTAURANT_1));
//    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete(REST_URL + RESTAURANT_1_ID).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
        RESTAURANT_MATCHER.assertCollectionEquals(Arrays.asList(RESTAURANT_2, RESTAURANT_3), service.getAll());
    }

    @Test
    public void testUpdate() throws Exception {
        Restaurant updated = new Restaurant(RESTAURANT_1);
        updated.setName("UpdatedName");
        mockMvc.perform(put(REST_URL + RESTAURANT_1_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andExpect(status().isOk());
        RESTAURANT_MATCHER.assertEquals(updated, service.get(RESTAURANT_1_ID));
    }

    @Test
    public void testCreate() throws Exception {
        Restaurant expected = new Restaurant(null, "new restaurant");
        ResultActions action = mockMvc.perform(post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(expected))).andExpect(status().isCreated());

        Restaurant returned = RESTAURANT_MATCHER.fromJsonAction(action);
        expected.setId(returned.getId());

        RESTAURANT_MATCHER.assertEquals(expected, returned);
        RESTAURANT_MATCHER.assertCollectionEquals(Arrays.asList(RESTAURANT_1, expected, RESTAURANT_2, RESTAURANT_3), service.getAll());
    }

    @Test
    public void testGetAll() throws Exception {
        TestUtil.print(mockMvc.perform(get(REST_URL).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(RESTAURANT_MATCHER.contentListMatcher(RESTAURANT_1, RESTAURANT_2, RESTAURANT_3)));
    }
}
