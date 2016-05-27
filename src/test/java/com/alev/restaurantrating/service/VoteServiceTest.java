package com.alev.restaurantrating.service;

import com.alev.restaurantrating.UserTestData;
import com.alev.restaurantrating.model.Vote;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static com.alev.restaurantrating.ModelTestData.*;
import static com.alev.restaurantrating.Profiles.DATAJPA;
import static com.alev.restaurantrating.UserTestData.USER;
import static com.alev.restaurantrating.UserTestData.USER_ID;
import static junit.framework.TestCase.assertTrue;

@ActiveProfiles(DATAJPA)
public class VoteServiceTest extends AbstractServiceTest {

    @Autowired
    protected VoteService service;

    @Test
    public void testSave() {
        Vote vote = new Vote(null, USER, NEXT_VOTE_DAY.plusDays(1), RESTAURANT_3, RESTAURANT_3_MENU);
        Vote created = service.save(vote, USER_ID);
        vote.setId(created.getId());
        VOTE_MATCHER.assertCollectionEquals(Arrays.asList(created, USER_VOTE_2, USER_VOTE_1), service.getAll(USER_ID));
    }

    @Test
    public void testDelete() {
        service.delete(USER_VOTE_1_ID, USER_ID);
        Collection<Vote> votes = service.getAll(USER_ID);
        assertTrue(votes.size() == 1);
        VOTE_MATCHER.assertCollectionEquals(Collections.singletonList(USER_VOTE_2), votes);
    }

    @Test
    public void testGet() {
        Vote actual = service.get(USER_VOTE_2_ID, USER_ID);
        VOTE_MATCHER.assertEquals(USER_VOTE_2, actual);
    }

    @Test
    public void testUpdate() {
        Vote updated = new Vote(USER_VOTE_2);
        updated.setRestaurant(RESTAURANT_3);
        updated.setMenu(RESTAURANT_3_MENU);
        service.update(updated, USER_ID);
        VOTE_MATCHER.assertEquals(updated, service.get(USER_VOTE_2_ID, USER_ID));
    }

    @Test
    public void testGetAll() {
        Vote vote = new Vote(null, USER, NEXT_VOTE_DAY.plusDays(1), RESTAURANT_3, RESTAURANT_3_MENU);
        service.save(vote, USER_ID);
        VOTE_MATCHER.assertCollectionEquals(Arrays.asList(vote, USER_VOTE_2, USER_VOTE_1), service.getAll(USER_ID));
    }

    @Test
    public void testGetWithFields() {
        Vote vote = service.getWithFields(USER_VOTE_1_ID, USER_ID);
        UserTestData.USER_MATCHER.assertEquals(USER, vote.getUser());
        Assert.assertEquals(VOTE_DAY, vote.getVoteDate());
        MENU_MATCHER.assertEquals(RESTAURANT_1_MENU, vote.getMenu());
        RESTAURANT_MATCHER.assertEquals(RESTAURANT_1, vote.getRestaurant());
    }
}
