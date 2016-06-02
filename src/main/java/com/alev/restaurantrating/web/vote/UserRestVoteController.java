package com.alev.restaurantrating.web.vote;

import com.alev.restaurantrating.web.ExceptionInfoHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AdminRestVoteController.REST_URL)
public class UserRestVoteController extends AbstractVoteController implements ExceptionInfoHandler {

    public static final String REST_URL = "/rest/profile/votes";
}