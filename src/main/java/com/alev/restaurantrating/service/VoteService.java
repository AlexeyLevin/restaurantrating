package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.Vote;

import java.time.LocalDate;
import java.util.Collection;

public interface VoteService {

    Vote get(int id, int userId);

    Vote save(Vote vote, int userId);

    void delete(int id, int userId);

    Collection<Vote> getAll(int userId);

    Vote update(Vote vote, int userId);

    Vote getWithFields(int id, int userId);

    Vote getWithoutUser(int id, int userId);

    Collection<Vote> getAllVotesForAllUsers();

    default Collection<Vote> getAllByDate(LocalDate date) {
        throw new UnsupportedOperationException();
    }

    default Vote getByDate(LocalDate date) {
        throw new UnsupportedOperationException();
    }
}
