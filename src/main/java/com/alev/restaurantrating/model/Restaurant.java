package com.alev.restaurantrating.model;

import java.time.LocalDate;

public class Restaurant {

    private String name;
    private LunchMenu lunchMenu;
    private LocalDate menuDate;

    public Restaurant(String name, LunchMenu lunchMenu) {
        this.name = name;
        this.lunchMenu = lunchMenu;
    }

    public Restaurant(String name, LunchMenu lunchMenu, LocalDate menuDate) {
        this.name = name;
        this.lunchMenu = lunchMenu;
        this.menuDate = menuDate;
    }

    public LunchMenu getLunchMenu() {
        return lunchMenu;
    }

    public void setLunchMenu(LunchMenu lunchMenu) {
        this.lunchMenu = lunchMenu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getMenuDate() {
        return menuDate;
    }

    public void setMenuDate(LocalDate menuDate) {
        this.menuDate = menuDate;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", lunchMenu=" + lunchMenu +
                ", menuDate=" + menuDate +
                '}';
    }
}
