package com.alev.restaurantrating;

import com.alev.restaurantrating.model.Vote;

import java.util.List;

public class VoteTest {
    public static void main(String[] args) {
        List<Vote> voteList = ModelTestData.USER_VOTE_LIST;
        voteList.forEach(System.out::println);
    }
}
