package com.alev.restaurantrating.web.vote;

import com.alev.restaurantrating.TestUtil;
import com.alev.restaurantrating.model.Vote;
import com.alev.restaurantrating.service.VoteService;
import com.alev.restaurantrating.to.VoteTo;
import com.alev.restaurantrating.util.json.JsonUtil;
import com.alev.restaurantrating.web.AbstractControllerTest;
import com.alev.restaurantrating.web.LoggedUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;
import java.util.Collections;

import static com.alev.restaurantrating.ModelTestData.*;
import static com.alev.restaurantrating.TestUtil.userHttpBasic;
import static com.alev.restaurantrating.UserTestData.ADMIN;
import static com.alev.restaurantrating.UserTestData.USER;
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

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete(REST_URL + USER_VOTE_1_ID).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
        VOTE_MATCHER.assertCollectionEquals(Collections.singletonList(USER_VOTE_2), voteService.getAll(LoggedUser.getId()));
    }

    @Test
    public void testUpdate() throws Exception {
        VoteTo updated = new VoteTo(USER_VOTE_1);
        updated.setRestaurant(RESTAURANT_3);
        updated.setMenu(RESTAURANT_3_MENU);
        updated.setVoteDate(LocalDate.now());
        mockMvc.perform(put(REST_URL + USER_VOTE_1_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andExpect(status().isOk());

        VOTE_TO_MATCHER.assertEquals(updated, new VoteTo(voteService.getWithFields(USER_VOTE_1_ID, LoggedUser.getId())));
    }

    @Test
    public void testCreate() throws Exception {
        VoteTo expected = new VoteTo(new Vote(0, USER, LocalDate.now(), RESTAURANT_2, RESTAURANT_2_MENU));
        System.out.println(expected);
        ResultActions action = mockMvc.perform(post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(expected))
                .with(userHttpBasic(ADMIN)));

        VoteTo returned = VOTE_TO_MATCHER.fromJsonAction(action);
        expected.setId(returned.getId());

        VOTE_TO_MATCHER.assertEquals(expected, returned);
        VOTE_TO_MATCHER.assertEquals(returned, new VoteTo(voteService.getWithFields(returned.getId(), LoggedUser.getId())));
    }

    @Test
    public void testGetAll() throws Exception {
        TestUtil.print(mockMvc.perform(get(REST_URL).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(VOTE_MATCHER.contentListMatcher(USER_VOTE_2, USER_VOTE_1)));
    }
}
