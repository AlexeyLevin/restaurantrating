package com.alev.restaurantrating.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDate;

@Entity
@Table(name = "menus", uniqueConstraints = {@UniqueConstraint(columnNames = {"menu_date", "restaurant_id"}, name = "menu_date_idx")})
public class LunchMenu extends NamedEntity {

    @Column(name = "menu_date", nullable = false)
    private LocalDate menuDate;

    public LunchMenu() {
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

    @Override
    public String toString() {
        return "LunchMenu{" +
                "name='" + name + '\'' +
                '}';
    }
}
