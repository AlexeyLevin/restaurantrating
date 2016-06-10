package com.alev.restaurantrating.web.menu;

import com.alev.restaurantrating.model.Menu;
import com.alev.restaurantrating.service.MenuService;
import com.alev.restaurantrating.util.json.JsonUtil;
import com.alev.restaurantrating.web.AbstractControllerTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.Collections;

import static com.alev.restaurantrating.ModelTestData.*;
import static com.alev.restaurantrating.TestUtil.userHttpBasic;
import static com.alev.restaurantrating.UserTestData.ADMIN;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MenuRestControllerTest extends AbstractControllerTest {
    public static final String REST_URL = AdminRestMenuController.REST_URL + '/';

    @Autowired
    private MenuService menuService;

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get(REST_URL + RESTAURANT_1_MENU_ID, RESTAURANT_1_ID)
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MENU_MATCHER.contentMatcher(RESTAURANT_1_MENU));
    }

    @Test
    public void testGetNotFound() throws Exception {
        mockMvc.perform(get(REST_URL + RESTAURANT_1_MENU_ID, RESTAURANT_2_ID)
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDeleteNotFound() throws Exception {
        mockMvc.perform(delete(REST_URL + RESTAURANT_3_MENU_ID, RESTAURANT_1_ID)
                .with(userHttpBasic(ADMIN)))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete(REST_URL + RESTAURANT_1_MENU_ID, RESTAURANT_1_ID)
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk());
        assertTrue(menuService.getAll(RESTAURANT_1_ID).isEmpty());
    }

    @Test
    public void testUpdate() throws Exception {
        Menu updated = new Menu(RESTAURANT_1_MENU_ID, RESTAURANT_1_NAME + STRING_MENU + " updated", VOTE_DAY);
        mockMvc.perform(put(REST_URL + RESTAURANT_1_MENU_ID, RESTAURANT_1_ID).contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated))
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk());
        assertEquals(updated, menuService.get(RESTAURANT_1_MENU_ID, RESTAURANT_1_ID));
    }

    @Test
    public void testCreate() throws Exception {
        Menu created = new Menu(RESTAURANT_1_NAME + STRING_MENU + " created", NEXT_VOTE_DAY);
        ResultActions action = mockMvc.perform(post(REST_URL, RESTAURANT_1_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(created))
                .with(userHttpBasic(ADMIN)));

        Menu returned = MENU_MATCHER.fromJsonAction(action);
        created.setId(returned.getId());

        MENU_MATCHER.assertEquals(created, returned);
        MENU_MATCHER.assertCollectionEquals(Arrays.asList(created, RESTAURANT_1_MENU), menuService.getAll(RESTAURANT_1_ID));
    }

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get(REST_URL, RESTAURANT_3_ID)
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MENU_MATCHER.contentListMatcher(Collections.singletonList(RESTAURANT_3_MENU)));
    }
}
