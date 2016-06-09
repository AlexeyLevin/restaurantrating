package com.alev.restaurantrating.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.Column;

@Entity
@Table(name = "dishes", uniqueConstraints = {@UniqueConstraint(columnNames = {"menu_id", "name"}, name = "menu_dishes_idx")})
public class Dish extends NamedEntity {

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    @Column(name = "price", nullable = false)
    private Float price;

    public Dish() {
    }

    public Dish(String name, Float price) {
        super(null, name);
        this.price = price;
    }

    public Dish(int id, String name, Float price) {
        super(id, name);
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Dish{"
                + "id=" + super.getId()
                + ", name='" + name + '\''
                + ", price=" + price
                + '}';
    }
}
