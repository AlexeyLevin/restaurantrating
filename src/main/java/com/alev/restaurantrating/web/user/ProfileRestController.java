package com.alev.restaurantrating.web.user;

import com.alev.restaurantrating.model.User;
import com.alev.restaurantrating.web.LoggedUser;

public class ProfileRestController extends AbstractUserController {

    public User get() {
        return super.get(LoggedUser.id());
    }

    public void delete() {
        super.delete(LoggedUser.id());
    }

    public void update(User user) {
        super.update(user, LoggedUser.id());
    }
}