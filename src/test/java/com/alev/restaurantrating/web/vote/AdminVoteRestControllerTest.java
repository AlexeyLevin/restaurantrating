package com.alev.restaurantrating.web.vote;

import com.alev.restaurantrating.TestUtil;
import com.alev.restaurantrating.model.Vote;
import com.alev.restaurantrating.service.VoteService;
import com.alev.restaurantrating.to.VoteTo;
import com.alev.restaurantrating.util.VoteUtil;
import com.alev.restaurantrating.util.json.JsonUtil;
import com.alev.restaurantrating.web.AbstractControllerTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;

import static com.alev.restaurantrating.ModelTestData.*;
import static com.alev.restaurantrating.TestUtil.userHttpBasic;
import static com.alev.restaurantrating.UserTestData.ADMIN;
import static com.alev.restaurantrating.UserTestData.ADMIN_ID;
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
        mockMvc.perform(get(REST_URL + ADMIN_VOTE_1_ID)
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(VOTE_MATCHER.contentMatcher(ADMIN_VOTE_1));
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete(REST_URL + ADMIN_VOTE_1_ID).contentType(MediaType.APPLICATION_JSON)
                .with(userHttpBasic(ADMIN)))
                .andDo(print())
                .andExpect(status().isOk());
        VOTE_MATCHER.assertCollectionEquals(Collections.singletonList(ADMIN_VOTE_2), voteService.getAll(ADMIN_ID));
    }

    @Test
    public void testUpdate() throws Exception {
        VoteUtil.setMaxVoteTime(LocalTime.MAX);
        VoteTo updated = new VoteTo(ADMIN_VOTE_1);
        updated.setRestaurant(RESTAURANT_3);
        updated.setMenu(RESTAURANT_3_MENU);
        updated.setVoteDate(LocalDate.now());
        mockMvc.perform(put(REST_URL + ADMIN_VOTE_1_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated))
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk());

        VOTE_TO_MATCHER.assertEquals(updated, new VoteTo(voteService.getWithFields(ADMIN_VOTE_1_ID, ADMIN_ID)));
        VoteUtil.setMaxVoteTime(VoteUtil.DEFAULT_MAX_VOTE_TIME);
    }

    @Test
    public void testCreate() throws Exception {
        VoteUtil.setMaxVoteTime(LocalTime.MAX);
        RESTAURANT_2_MENU.setMenuDate(LocalDate.now());
        VoteTo expected = new VoteTo(new Vote(null, ADMIN, LocalDate.now(), RESTAURANT_2, RESTAURANT_2_MENU));
        ResultActions action = mockMvc.perform(post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(expected))
                .with(userHttpBasic(ADMIN)));

        VoteTo returned = VOTE_TO_MATCHER.fromJsonAction(action);
        expected.setId(returned.getId());

        VOTE_TO_MATCHER.assertEquals(expected, returned);
        VOTE_TO_MATCHER.assertEquals(returned, new VoteTo(voteService.getWithFields(returned.getId(), ADMIN_ID)));
        VoteUtil.setMaxVoteTime(VoteUtil.DEFAULT_MAX_VOTE_TIME);
    }

    @Test
    public void testGetAll() throws Exception {
        TestUtil.print(mockMvc.perform(get(REST_URL).contentType(MediaType.APPLICATION_JSON)
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(VOTE_MATCHER.contentListMatcher(ADMIN_VOTE_2, ADMIN_VOTE_1)));
    }

    @Test
    public void testCreateVoteError() throws Exception {
        VoteUtil.setMaxVoteTime(LocalTime.MIN);
        RESTAURANT_2_MENU.setMenuDate(LocalDate.now());
        VoteTo expected = new VoteTo(new Vote(null, ADMIN, LocalDate.now(), RESTAURANT_2, RESTAURANT_2_MENU));
        mockMvc.perform(post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(expected))
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isUnprocessableEntity())
                .andDo(print());
        VoteUtil.setMaxVoteTime(VoteUtil.DEFAULT_MAX_VOTE_TIME);
    }

    @Test
    public void testUpdateVoteError() throws Exception {
        VoteUtil.setMaxVoteTime(LocalTime.MIN);
        VoteTo updated = new VoteTo(ADMIN_VOTE_1);
        updated.setRestaurant(RESTAURANT_3);
        updated.setMenu(RESTAURANT_3_MENU);
        updated.setVoteDate(LocalDate.now());
        mockMvc.perform(put(REST_URL + ADMIN_VOTE_1_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated))
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isUnprocessableEntity())
                .andDo(print());
        VoteUtil.setMaxVoteTime(VoteUtil.DEFAULT_MAX_VOTE_TIME);
    }
}
