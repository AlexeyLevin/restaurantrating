package com.alev.restaurantrating;

import com.alev.restaurantrating.model.Vote;

import java.util.List;

public class VoteTest {
    public static void main(String[] args) {
        List<Vote> userVoteList = ModelTestData.USER_VOTE_LIST;
        userVoteList.forEach(System.out::println);

        List<Vote> adminVoteList = ModelTestData.ADMIN_VOTE_LIST;
        adminVoteList.forEach(System.out::println);
    }
}
