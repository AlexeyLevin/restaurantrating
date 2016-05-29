package com.alev.restaurantrating.util;

import com.alev.restaurantrating.model.Vote;
import com.alev.restaurantrating.to.VoteTo;

public class VoteUtil {

    private VoteUtil() {
    }

    public static Vote saveFromTo(VoteTo voteTo) {
       return new Vote(voteTo.getId(), UserUtil.createFromTo(voteTo.getUser()), voteTo.getVoteDate(), voteTo.getRestaurant(), voteTo.getMenu());
    }
    public static Vote createFromTo(VoteTo voteTo) {
        return new Vote(null, UserUtil.createFromTo(voteTo.getUser()), voteTo.getVoteDate(), voteTo.getRestaurant(), voteTo.getMenu());
    }
}
