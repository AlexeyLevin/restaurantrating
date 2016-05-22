package com.alev.restaurantrating.repository.datajpa;

import com.alev.restaurantrating.model.Vote;

public interface VoteRepository {

    Vote get(int id);

    Vote save(Vote vote);

    void deleteVote(int id);
}
