package com.alev.restaurantrating.model;

import java.util.List;

public class LunchMenu {
    private String name;
    private List<Dish> dishList;
    private Restaurant restaurant;

    public LunchMenu(String name, List<Dish> dishList) {
        this.name = name;
        this.dishList = dishList;
    }

    public LunchMenu(String name, List<Dish> dishList, Restaurant restaurant) {
        this.name = name;
        this.dishList = dishList;
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

    @Override
    public String toString() {
        return "LunchMenu{" +
                "name='" + name + '\'' +
                ", dishList=" + dishList +
                ", restaurant=" + restaurant +
                '}';
    }
}
