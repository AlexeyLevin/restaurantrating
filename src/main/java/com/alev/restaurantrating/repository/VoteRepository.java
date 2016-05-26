package com.alev.restaurantrating.repository;

import com.alev.restaurantrating.model.Vote;

import java.util.Collection;

public interface VoteRepository {

    // null if updated vote do not belong to userId
    Vote save(Vote vote, int userId);

    // false if vote do not belong to userId
    boolean delete(int id, int userId);

    // null if vote do not belong to userId
    Vote get(int id, int userId);

    //ORDERED date
    Collection<Vote> getAll(int userId);

    Vote getWithFields(int id, int userId);
}
