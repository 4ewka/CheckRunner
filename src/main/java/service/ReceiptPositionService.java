package service;

import base.ProductBase;
import model.InputProduct;
import model.Product;
import model.ReceiptPosition;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReceiptPositionService {
    public ReceiptPosition createReceiptPosition(InputProduct inputProduct) {
        ReceiptPosition receiptPosition = new ReceiptPosition();
        Logger log = Logger.getLogger(InputVerification.class.getSimpleName());
        if (getProduct(inputProduct.getId()) == null) {
            log.log(Level.SEVERE, "ID not found");
            System.exit(0);
        }
        Product product = getProduct(inputProduct.getId());
        int positionCount = inputProduct.getQuantity();
        receiptPosition.setCount(positionCount);
        receiptPosition.setName(product.getName());
        receiptPosition.setPrice(product.getPrice().multiply(BigDecimal.valueOf(positionCount)));
        receiptPosition.setDiscount(getDiscountFromBase(product, receiptPosition));
        receiptPosition.setTotalPrice(receiptPosition.getPrice().subtract(receiptPosition.getDiscount()));
        return receiptPosition;
    }

    public BigDecimal getDiscountFromBase(Product product, ReceiptPosition receiptPosition) {
        if (product.getPromo() && receiptPosition.getCount() > 4) {
            BigDecimal priceWithoutDiscount = receiptPosition.getPrice();
            return priceWithoutDiscount.multiply(BigDecimal.valueOf(0.1)).setScale(2, RoundingMode.HALF_UP);
        } else {
            return BigDecimal.ZERO;
        }
    }

    private Product getProduct(int id) {
        ProductBase productBase = new ProductBase();
        Map<Integer, Product> products = productBase.getSnapshot();
        return products.get(id);
    }
}
