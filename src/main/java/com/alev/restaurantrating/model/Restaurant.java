package com.alev.restaurantrating.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "restaurants", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "restaurants_unique_name_idx")})
public class Restaurant extends NamedEntity {

    public Restaurant() {
    }
    //private LunchMenu lunchMenu;

    public Restaurant(Restaurant r) {
        super(r.getId(), r.getName());
    //    this.lunchMenu = r.getLunchMenu();
    }

    public Restaurant(Integer id, String name) {
        super(id, name);
    }



//    public LunchMenu getLunchMenu() {
//        return lunchMenu;
//    }
//
//    public void setLunchMenu(LunchMenu lunchMenu) {
//        this.lunchMenu = lunchMenu;
//    }
    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name=" + name +
//                ", lunchMenu=" + lunchMenu +
                '}';
    }
}
