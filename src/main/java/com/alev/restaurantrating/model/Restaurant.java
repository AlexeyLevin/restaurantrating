package com.alev.restaurantrating.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "restaurants", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "restaurants_unique_name_idx")})
public class Restaurant extends NamedEntity {

    public Restaurant() {
    }

    public Restaurant(Restaurant r) {
        super(r.getId(), r.getName());
    }

    public Restaurant(Integer id, String name) {
        super(id, name);
    }

//    @JsonIgnore
//    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "restaurant")
//    private Collection<Vote> votes;
//
//    @JsonIgnore
//    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "restaurant")
//    private Collection<Menu> menus;
//
//    public Collection<Vote> getVotes() {
//        return votes;
//    }
//
//    public void setVotes(Collection<Vote> votes) {
//        this.votes = votes;
//    }
//
//    public Collection<Menu> getMenus() {
//        return menus;
//    }
//
//    public void setMenus(Collection<Menu> menus) {
//        this.menus = menus;
//    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
