package com.alev.restaurantrating.to;

import com.alev.restaurantrating.model.Menu;
import com.alev.restaurantrating.model.Restaurant;
import com.alev.restaurantrating.model.Vote;
import com.alev.restaurantrating.util.UserUtil;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

public class VoteTo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotNull
    protected UserTo user;

    @NotNull
    protected LocalDate voteDate;

    @NotNull
    protected Restaurant restaurant;

    @NotNull
    protected Menu menu;

    public VoteTo() {
    }

    public VoteTo(int id, UserTo user, LocalDate voteDate, Restaurant restaurant, Menu menu) {
        this.id = id;
        this.user = user;
        this.voteDate = voteDate;
        this.restaurant = restaurant;
        this.menu = menu;
    }

    public VoteTo(Vote vote) {
        this.id = vote.getId();
        this.user = UserUtil.asTo(vote.getUser());
        this.voteDate = vote.getVoteDate();
        this.restaurant = vote.getRestaurant();
        this.menu = vote.getMenu();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserTo getUser() {
        return user;
    }

    public void setUserTo(UserTo user) {
        this.user = user;
    }

    public LocalDate getVoteDate() {
        return voteDate;
    }

    public void setVoteDate(LocalDate voteDate) {
        this.voteDate = voteDate;
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

    @Override
    public String toString() {
        return "VoteTo{" +
                "id=" + id +
                ", user=" + user +
                ", voteDate=" + voteDate +
                ", restaurant=" + restaurant +
                ", menu=" + menu +
                '}';
    }
}
