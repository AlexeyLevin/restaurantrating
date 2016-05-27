package com.alev.restaurantrating.web.menu;

import com.alev.restaurantrating.service.MenuService;
import com.alev.restaurantrating.web.AbstractControllerTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static com.alev.restaurantrating.ModelTestData.*;
import static junit.framework.TestCase.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MenuRestControllerTest extends AbstractControllerTest {
    public static final String REST_URL = AdminRestMenuController.REST_URL + '/';

    @Autowired
    private MenuService menuService;

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get(REST_URL + RESTAURANT_1_MENU_ID, RESTAURANT_1_ID))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MENU_MATCHER.contentMatcher(RESTAURANT_1_MENU));
    }

//    @Test
//    public void testGetNotFound() throws Exception {
//        mockMvc.perform(get(REST_URL + RESTAURANT_1_MENU_ID, RESTAURANT_2_ID))
//                .andExpect(status().isNotFound());
//    }

//    @Test
//    public void testDeleteNotFound() throws Exception {
//        mockMvc.perform(delete(REST_URL + ADMIN_MEAL_ID)
//                .with(userHttpBasic(USER)))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    }
//
    @Test
    public void testDelete() throws Exception {
//        MENU_MATCHER.assertCollectionEquals(Collections.singletonList(RESTAURANT_1_MENU), menuService.getAll(RESTAURANT_1_ID));
        mockMvc.perform(delete(REST_URL + RESTAURANT_1_MENU_ID, RESTAURANT_1_ID))
                .andExpect(status().isOk());
        assertTrue(menuService.getAll(RESTAURANT_1_ID).isEmpty());
    }
//
//    @Test
//    public void testUpdate() throws Exception {
//        UserMeal updated = getUpdated();
//
//        mockMvc.perform(put(REST_URL + MEAL1_ID).contentType(MediaType.APPLICATION_JSON)
//                .content(JsonUtil.writeValue(updated))
//                .with(userHttpBasic(USER)))
//                .andExpect(status().isOk());
//
//        assertEquals(updated, service.get(MEAL1_ID, START_SEQ));
//    }
//
//    @Test
//    public void testCreate() throws Exception {
//        UserMeal created = getCreated();
//        ResultActions action = mockMvc.perform(post(REST_URL)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(JsonUtil.writeValue(created))
//                .with(userHttpBasic(ADMIN)));
//
//        UserMeal returned = MENU_MATCHER.fromJsonAction(action);
//        created.setId(returned.getId());
//
//        MENU_MATCHER.assertEquals(created, returned);
//        MENU_MATCHER.assertCollectionEquals(Arrays.asList(ADMIN_MEAL2, created, ADMIN_MEAL), service.getAll(ADMIN_ID));
//    }
//
//    @Test
//    public void testGetAll() throws Exception {
//        mockMvc.perform(get(REST_URL)
//                .with(userHttpBasic(USER)))
//                .andExpect(status().isOk())
//                .andDo(print())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MENU_MATCHER.contentListMatcher(UserMealsUtil.getWithExceeded(USER_MEALS, USER.getCaloriesPerDay())));
//    }
//
//    @Test
//    public void testGetBetween() throws Exception {
//        mockMvc.perform(get(REST_URL + "between?startDateTime=2015-05-30T07:00&endDateTime=2015-05-31T11:00:00")
//                .with(userHttpBasic(USER)))
//                .andExpect(status().isOk())
//                .andDo(print())
//                .andExpect(MENU_MATCHER.contentListMatcher(
//                        UserMealsUtil.createWithExceed(MEAL4, true),
//                        UserMealsUtil.createWithExceed(MEAL1, false)));
//    }
//
//    @Test
//    public void testFilter() throws Exception {
//        mockMvc.perform(get(REST_URL + "filter?startDate=2015-05-30&startTime=07:00&endDate=2015-05-31&endTime=11:00")
//                .with(userHttpBasic(USER)))
//                .andExpect(status().isOk())
//                .andDo(print())
//                .andExpect(MENU_MATCHER.contentListMatcher(
//                        UserMealsUtil.createWithExceed(MEAL4, true),
//                        UserMealsUtil.createWithExceed(MEAL1, false)));
//    }
//
//    @Test
//    public void testFilterAll() throws Exception {
//        mockMvc.perform(get(REST_URL + "filter?startDate=&endTime=")
//                .with(userHttpBasic(USER)))
//                .andExpect(status().isOk())
//                .andDo(print())
//                .andExpect(MENU_MATCHER.contentListMatcher(
//                        UserMealsUtil.getWithExceeded(Arrays.asList(MEAL6, MEAL5, MEAL4, MEAL3, MEAL2, MEAL1), USER.getCaloriesPerDay())));
//    }
//
}
