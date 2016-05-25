package com.alev.restaurantrating.model;

import java.time.LocalDate;

public class Vote extends BaseEntity {

    private LocalDate voteDateTime;

    private Restaurant restaurant;

    private Menu menu;

    private User user;

    public Vote(LocalDate voteDateTime, Restaurant restaurant, Menu menu) {
        this.voteDateTime = voteDateTime;
        this.restaurant = restaurant;
        this.menu = menu;
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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
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
                ", menu=" + menu +
                '}';
    }
}
