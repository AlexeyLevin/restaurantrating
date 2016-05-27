package com.alev.restaurantrating.web.user;

import com.alev.restaurantrating.TestUtil;
import com.alev.restaurantrating.model.Role;
import com.alev.restaurantrating.model.User;
import com.alev.restaurantrating.web.AbstractControllerTest;
import com.alev.restaurantrating.web.json.JsonUtil;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.Collections;

import static com.alev.restaurantrating.UserTestData.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AdminRestControllerTest extends AbstractControllerTest {

    public static final String REST_URL = AdminRestController.REST_URL + '/';

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get(REST_URL + ADMIN_ID))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(USER_MATCHER.contentMatcher(ADMIN));
    }

    @Test
    public void testGetByEmail() throws Exception {
        mockMvc.perform(get(REST_URL + "by?email=" + USER.getEmail()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(USER_MATCHER.contentMatcher(USER));
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete(REST_URL + USER_ID).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
        USER_MATCHER.assertCollectionEquals(Collections.singletonList(ADMIN), userService.getAll());
    }

    @Test
    public void testUpdate() throws Exception {
        User updated = new User(USER);
        updated.setName("UpdatedName");
        updated.setRoles(Collections.singletonList(Role.ROLE_ADMIN));
        mockMvc.perform(put(REST_URL + USER_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andExpect(status().isOk());

        USER_MATCHER.assertEquals(updated, userService.get(USER_ID));
    }

    @Test
    public void testCreate() throws Exception {
        TestUser expected = new TestUser("New", "new@gmail.com", "newPass", Role.ROLE_USER, Role.ROLE_ADMIN);
        ResultActions action = mockMvc.perform(post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(expected.asUser()))).andExpect(status().isCreated());

        User returned = USER_MATCHER.fromJsonAction(action);
        expected.setId(returned.getId());

        USER_MATCHER.assertEquals(expected, returned);
        USER_MATCHER.assertCollectionEquals(Arrays.asList(ADMIN, expected, USER), userService.getAll());
    }

    @Test
    public void testGetAll() throws Exception {
        TestUtil.print(mockMvc.perform(get(REST_URL).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(USER_MATCHER.contentListMatcher(ADMIN, USER)));
    }
}