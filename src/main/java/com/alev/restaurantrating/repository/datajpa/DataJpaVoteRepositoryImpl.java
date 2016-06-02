package com.alev.restaurantrating.repository.datajpa;

import com.alev.restaurantrating.model.Vote;
import com.alev.restaurantrating.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
public class DataJpaVoteRepositoryImpl implements VoteRepository {

    @Autowired
    private ProxyVoteRepository proxy;

    @Autowired
    private ProxyUserRepository userProxy;

    @Override
    @Transactional
    public Vote save(Vote vote, int userId) {
        if (!vote.isNew() && get(vote.getId(), userId) == null) {
            return null;
        }
        vote.setUser(userProxy.getOne(userId));
        return proxy.save(vote);
    }

    @Override
    public boolean delete(int id, int userId) {
        return proxy.delete(id, userId) != 0;
    }

    @Override
    public Vote get(int id, int userId) {
        return proxy.get(id, userId);
    }

    @Override
    public Collection<Vote> getAll(int userId) {
        return proxy.getAll(userId);
    }

    @Override
    public Vote getWithFields(int id, int userId) {
        return  proxy.getWithFields(id, userId);
    }

    @Override
    public Vote getWithoutUser(int id, int userId) {
        return  proxy.getWithoutUser(id, userId);
    }
}