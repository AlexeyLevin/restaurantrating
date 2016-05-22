package com.alev.restaurantrating.web;

import com.alev.restaurantrating.model.BaseEntity;

public class LoggedUser {
    public static int id = BaseEntity.START_SEQ;

    public static int id() {
        return id;
    }

    public static void setId(int id) {
        LoggedUser.id = id;
    }
}