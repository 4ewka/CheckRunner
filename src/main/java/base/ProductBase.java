package base;

import model.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductBase {

    public Map<Integer, Product> getSnapshot() {
        Map<Integer, Product> database = new HashMap<>();
        database.put(1, new Product("Apple", BigDecimal.valueOf(0.56), true));
        database.put(2, new Product("Pineapple", BigDecimal.valueOf(2.15), true));
        database.put(3, new Product("Feed", BigDecimal.valueOf(2.65), false));
        database.put(4, new Product("Cola", BigDecimal.valueOf(1.5), false));
        return database;
    }
}
