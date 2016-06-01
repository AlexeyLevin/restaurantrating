package com.alev.restaurantrating.util;

import com.alev.restaurantrating.model.Vote;
import com.alev.restaurantrating.to.VoteTo;

import java.time.LocalTime;

public class VoteUtil {

    public static final LocalTime DEFAULT_MAX_VOTE_TIME = LocalTime.of(11,0,0);



    private static LocalTime maxVoteTime = DEFAULT_MAX_VOTE_TIME;

    private VoteUtil() {
    }

    public static Vote saveFromTo(VoteTo voteTo) {
       return new Vote(voteTo.getId(), UserUtil.createFromTo(voteTo.getUser()), voteTo.getVoteDate(), voteTo.getRestaurant(), voteTo.getMenu());
    }
    public static Vote createFromTo(VoteTo voteTo) {
        return new Vote(null, UserUtil.createFromTo(voteTo.getUser()), voteTo.getVoteDate(), voteTo.getRestaurant(), voteTo.getMenu());
    }

    public static void setMaxVoteTime(LocalTime maxVoteTime) {
        VoteUtil.maxVoteTime = maxVoteTime;
    }

    public static LocalTime getMaxVoteTime() {
        return maxVoteTime;
    }
}
