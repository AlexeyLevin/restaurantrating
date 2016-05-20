package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.Vote;

public interface VoteService {

    Vote get(int id, int userId);

    Vote save(Vote vote, int userId);

    void delete(int id, int userId);
}
