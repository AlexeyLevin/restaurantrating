package com.alev.restaurantrating.web.vote;

import com.alev.restaurantrating.model.Vote;
import com.alev.restaurantrating.service.VoteService;
import com.alev.restaurantrating.to.VoteTo;
import com.alev.restaurantrating.web.LoggedUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class AbstractVoteController {
    private final Logger LOG = LoggerFactory.getLogger(AbstractVoteController.class);

    @Autowired
    private VoteService voteService;

    public Vote get(int id) {
        int userId = LoggedUser.id();
        LOG.info("get vote {} for User {}", id, userId);
        return voteService.get(id, userId);
    }

    public VoteTo getWithFields(int id) {
        int userId = LoggedUser.id();
        LOG.info("getWithFields vote {} for User {}", id, userId);
        return new VoteTo(voteService.getWithFields(id, userId));
    }

    public void delete(int id) {
        int userId = LoggedUser.id();
        LOG.info("delete vote {} for User {}", id, userId);
        voteService.delete(id, userId);
    }

    public Collection<Vote> getAll() {
        int userId = LoggedUser.id();
        LOG.info("getAll for User {}", userId);
        return voteService.getAll(userId);
    }

    public void update(Vote vote, int id) {
        vote.setId(id);
        int userId = LoggedUser.id();
        LOG.info("update {} for User {}", vote, userId);
        voteService.update(vote, userId);
    }

    public Vote create(Vote vote) {
        vote.setId(null);
        int userId = LoggedUser.id();
        LOG.info("create {} for User {}", vote, userId);
        return voteService.save(vote, userId);
    }
}
