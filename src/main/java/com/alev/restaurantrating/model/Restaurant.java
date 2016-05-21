package com.alev.restaurantrating.model;

public class Restaurant extends NamedEntity {

    private LunchMenu lunchMenu;

    public Restaurant(Restaurant r) {
        super(r.getId(), r.getName());
        this.lunchMenu = r.getLunchMenu();
    }

    public Restaurant(Integer id, String name) {
        super(id, name);
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

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", lunchMenu=" + lunchMenu +
                '}';
    }
}
