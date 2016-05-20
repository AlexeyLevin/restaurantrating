package com.alev.restaurantrating.model;

import java.time.LocalDateTime;

public class Vote extends BaseEntity {

    private LocalDateTime voteDateTime;

    private Restaurant restaurant;

    private LunchMenu lunchMenu;

    private boolean isVoted;

    public Vote(LocalDateTime voteDateTime, Restaurant restaurant, LunchMenu lunchMenu, boolean isVoted) {
        this.voteDateTime = voteDateTime;
        this.restaurant = restaurant;
        this.lunchMenu = lunchMenu;
        this.isVoted = isVoted;
    }

    public LocalDateTime getVoteDateTime() {
        return voteDateTime;
    }

    public void setVoteDateTime(LocalDateTime voteDateTime) {
        this.voteDateTime = voteDateTime;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LunchMenu getLunchMenu() {
        return lunchMenu;
    }

    public void setLunchMenu(LunchMenu lunchMenu) {
        this.lunchMenu = lunchMenu;
    }

    public boolean isVoted() {
        return isVoted;
    }

    public void setVoted(boolean voted) {
        isVoted = voted;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "voteDateTime=" + voteDateTime +
                ", restaurant=" + restaurant +
                ", lunchMenu=" + lunchMenu +
                ", isVoted=" + isVoted +
                '}';
    }
}
