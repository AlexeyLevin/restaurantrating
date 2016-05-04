package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.LunchMenu;

public interface VoteService {
    void addVote(LunchMenu restaurantMenu);
    void deleteVote(LunchMenu restaurantMenu);
}
