package com.alev.restaurantrating.web;

import com.alev.restaurantrating.model.User;
import com.alev.restaurantrating.to.UserTo;
import com.alev.restaurantrating.util.UserUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import static java.util.Objects.requireNonNull;

public class LoggedUser extends org.springframework.security.core.userdetails.User {
    private final UserTo userTo;

    public LoggedUser(User user) {
        super(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, user.getRoles());
        this.userTo = UserUtil.asTo(user);
    }

    public static LoggedUser safeGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object user = auth.getPrincipal();
        return (user instanceof LoggedUser) ? (LoggedUser) user : null;
    }

    public static LoggedUser get() {
        LoggedUser user = safeGet();
        requireNonNull(user, "No authorized user found");
        return user;
    }

    public static int id() {
        return get().userTo.getId();
    }

    public UserTo getUserTo() {
        return userTo;
    }

    @Override
    public String toString() {
        return userTo.toString();
    }
}