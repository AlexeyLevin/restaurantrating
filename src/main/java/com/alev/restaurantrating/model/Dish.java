package com.alev.restaurantrating.model;

import java.math.BigDecimal;

public class Dish {
    private String name;
    private BigDecimal price;

    public Dish(String name, BigDecimal price) {
        this.name = name;
        this.price = price.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
