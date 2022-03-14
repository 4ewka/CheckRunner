package model;

import java.math.BigDecimal;
import java.util.Scanner;

public class Product {
    private final String name;
    private final BigDecimal price;
    private final Boolean promo;


    private final int id;

    public Product(String str) {
        Scanner scanner = new Scanner(str);
        scanner.useDelimiter(";");
        this.id = scanner.nextInt();
        this.name = (scanner.next());
        double temp = Double.parseDouble(scanner.next());
        this.price = BigDecimal.valueOf(temp);
        this.promo = str.endsWith("y");

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

    public int getId() {
        return id;
    }
}
