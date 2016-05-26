package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.Vote;
import com.alev.restaurantrating.repository.VoteRepository;
import com.alev.restaurantrating.util.exceptions.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    VoteRepository repository;

    @Override
    public Vote get(int id, int userId) {
        return ExceptionUtil.check(repository.get(id, userId), id);
    }

    @Override
    public Vote save(Vote vote, int userId) {
        return repository.save(vote, userId);
    }

    @Override
    public void delete(int id, int userId) {
        ExceptionUtil.check(repository.delete(id, userId), id);
    }

    @Override
    public Collection<Vote> getAll(int userId) {
        return repository.getAll(userId);
    }

    @Override
    public Vote update(Vote vote, int userId) {
        return ExceptionUtil.check(repository.save(vote, userId), vote.getId());
    }

    @Override
    public Vote getWithFields(int id, int userId) {
        return repository.getWithFields(id, userId);
    }
}
