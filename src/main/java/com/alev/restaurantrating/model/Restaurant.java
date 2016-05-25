package com.alev.restaurantrating.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "restaurants", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "restaurants_unique_name_idx")})
public class Restaurant extends NamedEntity {

    public Restaurant() {
    }
    //private Menu menu;

    public Restaurant(Restaurant r) {
        super(r.getId(), r.getName());
    //    this.menu = r.getMenu();
    }

    public Restaurant(Integer id, String name) {
        super(id, name);
    }


//    public Menu getMenu() {
//        return menu;
//    }
//
//    public void setLunchMenu(Menu menu) {
//        this.menu = menu;
//    }
    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name=" + name +
//                ", menu=" + menu +
                '}';
    }
}
