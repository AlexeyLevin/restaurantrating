package com.alev.restaurantrating.model;

import java.time.LocalDate;
import java.util.List;

public class LunchMenu {
    private String name;
    private List<Dish> dishList;
    private LocalDate menuDate;
    private Restaurant restaurant;

    public LunchMenu(String name, List<Dish> dishList) {
        this.name = name;
        this.dishList = dishList;
    }

    public LunchMenu(String name, List<Dish> dishList, LocalDate menuDate, Restaurant restaurant) {
        this.name = name;
        this.dishList = dishList;
        this.menuDate = menuDate;
        this.restaurant = restaurant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDate getMenuDate() {
        return menuDate;
    }

    public void setMenuDate(LocalDate menuDate) {
        this.menuDate = menuDate;
    }
}
