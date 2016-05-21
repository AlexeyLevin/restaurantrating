package com.alev.restaurantrating.model;

import java.time.LocalDate;

public class Vote extends BaseEntity {

    private LocalDate voteDateTime;

    private Restaurant restaurant;

    private LunchMenu lunchMenu;

    private boolean isVoted;

    private User user;

    public Vote(LocalDate voteDateTime, Restaurant restaurant, LunchMenu lunchMenu, boolean isVoted) {
        this.voteDateTime = voteDateTime;
        this.restaurant = restaurant;
        this.lunchMenu = lunchMenu;
        this.isVoted = isVoted;
    }

    public LocalDate getVoteDateTime() {
        return voteDateTime;
    }

    public void setVoteDateTime(LocalDate voteDateTime) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
