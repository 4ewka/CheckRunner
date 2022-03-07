package model;

import java.math.BigDecimal;

public class Product {
    private final String name;
    private final BigDecimal price;
    private final Boolean promo;

    public Product(String name, BigDecimal price, Boolean promo) {
        this.name = name;
        this.price = price;
        this.promo = promo;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Boolean getPromo() {
        return promo;
    }
}
