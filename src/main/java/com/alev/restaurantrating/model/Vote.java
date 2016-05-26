package com.alev.restaurantrating.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "votes", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "vote_date", "restaurant_id", "menu_id"}, name = "user_date_restaurant_menu_unique_idx")})
public class Vote extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "vote_date", nullable = false)
    private LocalDate voteDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    public Vote() {
    }

    public Vote(Integer id, User user, LocalDate voteDate, Restaurant restaurant, Menu menu) {
        super(id);
        this.user = user;
        this.voteDate = voteDate;
        this.restaurant = restaurant;
        this.menu = menu;
    }

    public Vote(Vote vote) {
        super(vote.getId());
        this.user = vote.getUser();
        this.voteDate =  vote.getVoteDate();
        this.restaurant = vote.getRestaurant();
        this.menu = vote.getMenu();
    }

    public LocalDate getVoteDate() {
        return voteDate;
    }

    public void setVoteDate(LocalDate voteDateTime) {
        this.voteDate = voteDateTime;
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
                "id=" + id +
                ", voteDate=" + voteDate +
                '}';
    }
}
