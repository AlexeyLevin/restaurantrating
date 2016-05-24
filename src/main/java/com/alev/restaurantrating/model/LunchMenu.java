package com.alev.restaurantrating.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "menus", uniqueConstraints = {@UniqueConstraint(columnNames = {"restaurant_id", "menu_date"}, name = "menu_date_idx")})
public class LunchMenu extends NamedEntity {

    @Column(name = "menu_date", nullable = false)
    private LocalDate menuDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "menu")
    private Collection<Dish> dishes;

    public LunchMenu() {
    }

    public LunchMenu(String name, LocalDate menuDate) {
        super(null, name);
        this.menuDate = menuDate;
    }

    public LunchMenu(Integer id, String name, LocalDate menuDate) {
        super(id, name);
        this.menuDate = menuDate;
    }

    public LocalDate getMenuDate() {
        return menuDate;
    }

    public void setMenuDate(LocalDate menuDate) {
        this.menuDate = menuDate;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Collection<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Collection<Dish> dishes) {
        this.dishes = dishes;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "LunchMenu{" +
                "id=" + id +
                ", name=" + name +
                ", menuDate=" + menuDate +
                '}';
    }
}
