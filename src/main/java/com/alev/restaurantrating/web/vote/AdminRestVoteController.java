package com.alev.restaurantrating.web.vote;

import com.alev.restaurantrating.model.Vote;
import com.alev.restaurantrating.to.VoteTo;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

import static com.alev.restaurantrating.util.VoteUtil.createFromTo;
import static com.alev.restaurantrating.util.VoteUtil.fromTo;

@RestController
@RequestMapping(AdminRestVoteController.REST_URL)
public class AdminRestVoteController extends AbstractVoteController {

    public static final String REST_URL = "/rest/admin/votes";

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Vote get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @RequestMapping(value = "/getFullVote/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public VoteTo getWithFields(@PathVariable("id") int id) {
        return super.getWithFields(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Vote> getAll() {
        return super.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody VoteTo voteTo, @PathVariable("id") int id) {
        super.update(fromTo(voteTo), id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VoteTo> createWithLocation(@RequestBody VoteTo voteTo) {
        Vote created;
        if (voteTo.getId() == 0) {
            created = super.create(createFromTo(voteTo));
        } else {
            created = super.create(fromTo(voteTo));
        }
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(voteTo);
    }
}
