package com.alev.restaurantrating.web.vote;

import com.alev.restaurantrating.TestUtil;
import com.alev.restaurantrating.model.Vote;
import com.alev.restaurantrating.service.VoteService;
import com.alev.restaurantrating.util.json.JsonUtil;
import com.alev.restaurantrating.web.AbstractControllerTest;
import com.alev.restaurantrating.web.LoggedUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.time.LocalDate;
import java.util.Collections;

import static com.alev.restaurantrating.ModelTestData.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AdminVoteRestControllerTest extends AbstractControllerTest {
    public static final String REST_URL = AdminRestVoteController.REST_URL + '/';

    @Autowired
    private VoteService voteService;

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get(REST_URL + USER_VOTE_1_ID))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(VOTE_MATCHER.contentMatcher(USER_VOTE_1));
    }

//    @Test
//    public void testGetByEmail() throws Exception {
//        mockMvc.perform(get(REST_URL + "by?email=" + USER.getEmail()))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(VOTE_MATCHER.contentMatcher(USER));
//    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete(REST_URL + USER_VOTE_1_ID).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
        VOTE_MATCHER.assertCollectionEquals(Collections.singletonList(USER_VOTE_2), voteService.getAll(LoggedUser.getId()));
    }

    @Test
    public void testUpdate() throws Exception {
        Vote updated = new Vote(USER_VOTE_1);
        updated.setRestaurant(RESTAURANT_3);
        updated.setMenu(RESTAURANT_3_MENU);
        updated.setVoteDate(LocalDate.now());
        mockMvc.perform(put(REST_URL + USER_VOTE_1_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andExpect(status().isOk());

        VOTE_MATCHER.assertEquals(updated, voteService.getWithFields(USER_VOTE_1_ID, LoggedUser.getId()));
    }

//    @Test
//    public void testCreate() throws Exception {
//        Vote expected = new Vote(null, USER, LocalDate.now(), RESTAURANT_3, RESTAURANT_3_MENU);
//        ResultActions action = mockMvc.perform(post(REST_URL)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(JsonUtil.writeValue(expected))).andExpect(status().isCreated());
//
//        Vote returned = VOTE_MATCHER.fromJsonAction(action);
//        expected.setId(returned.getId());
//
//        VOTE_MATCHER.assertEquals(expected, returned);
//        VOTE_MATCHER.assertCollectionEquals(Arrays.asList(expected, USER_VOTE_2, USER_VOTE_1), voteService.getAll(USER.getId()));
//    }

    @Test
    public void testGetAll() throws Exception {
        TestUtil.print(mockMvc.perform(get(REST_URL).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(VOTE_MATCHER.contentListMatcher(USER_VOTE_2, USER_VOTE_1)));
    }
}
