package com.alev.restaurantrating.web.user;

import com.alev.restaurantrating.TestUtil;
import com.alev.restaurantrating.model.User;
import com.alev.restaurantrating.to.UserTo;
import com.alev.restaurantrating.util.UserUtil;
import com.alev.restaurantrating.web.AbstractControllerTest;
import com.alev.restaurantrating.util.json.JsonUtil;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.util.Collections;

import static com.alev.restaurantrating.UserTestData.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProfileRestControllerTest extends AbstractControllerTest {

    public static final String REST_URL = ProfileRestController.REST_URL + '/';

    @Test
    public void testGet() throws Exception {
        TestUtil.print(mockMvc.perform(get(REST_URL)
                .with(TestUtil.userHttpBasic(USER)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(USER_MATCHER.contentMatcher(USER)));
    }

    @Test
    public void testGetUnauth() throws Exception {
        mockMvc.perform(get(REST_URL))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete(REST_URL)
                .with(TestUtil.userHttpBasic(USER)))
                .andExpect(status().isOk());
        USER_MATCHER.assertCollectionEquals(Collections.singletonList(ADMIN), userService.getAll());
    }

    @Test
    public void testUpdate() throws Exception {
        UserTo updatedTo = new UserTo(0, "newName", "newemail@ya.ru", "newPassword");

        mockMvc.perform(put(REST_URL).contentType(MediaType.APPLICATION_JSON)
                .with(TestUtil.userHttpBasic(USER))
                .content(JsonUtil.writeValue(updatedTo)))
                .andDo(print())
                .andExpect(status().isOk());

        USER_MATCHER.assertEquals(UserUtil.updateFromTo(new User(USER), updatedTo), new User(userService.getByEmail("newemail@ya.ru")));
    }
}