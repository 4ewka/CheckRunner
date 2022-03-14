package base;

import constants.PathConstant;
import model.Product;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductBase {
    private final Map<Integer, Product> snapshot;

    public ProductBase() {
        Map<Integer, Product> database = new HashMap<>();
        File file = new File(PathConstant.VALID_BASE);
        String str;
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
                Product product = new Product(str);
                if (database.put(product.getId(), product) != null) {
                    System.out.println(("Contains multiple IDs: " + product.getId() +
                            "\nPlease check the input"));
                    System.exit(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.snapshot = database;
    }

    public Map<Integer, Product> getSnapshot() {
        return snapshot;
    }
}
