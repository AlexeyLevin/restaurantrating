package com.alev.restaurantrating.model;

import java.time.LocalDateTime;

public class Vote {
    private int user_id;
    private LocalDateTime voteDate;
    private Restaurant restaurant;
    private LunchMenu lunchMenu;
    private boolean isVoted;
}
