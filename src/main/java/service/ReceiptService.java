package service;

import model.InputData;
import model.InputProduct;
import model.Receipt;
import model.ReceiptPosition;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ReceiptService {
    public static int receiptNumber = 0;

    public Receipt createReceipt(InputData inputData) {
        Receipt receipt = new Receipt();
        ReceiptNumberService receiptNumberService = new ReceiptNumberService();
        ReceiptService.receiptNumber = receiptNumberService.getLastNumber() + 1;
        receipt.setDate();
        receipt.setPositions(createPositions(inputData.getInputProducts()));
        receipt.setTotalPrice(calcTotalPrice(receipt.getPositions()));
        receipt.setToPay(receipt.getTotalPrice());
        DiscountService discountService = new DiscountService();
        receipt.setPromo(discountService.setDiscount(inputData, receipt));
        receipt.setToPay(receipt.getTotalPrice().subtract(receipt.getPromo()));
        return receipt;
    }

    public ArrayList<ReceiptPosition> createPositions(List<InputProduct> inputProducts) {
        ArrayList<ReceiptPosition> positions = new ArrayList<>();
        ReceiptPositionService receiptPositionService = new ReceiptPositionService();
        for (InputProduct inputProduct : inputProducts) {
            positions.add(receiptPositionService.createReceiptPosition(inputProduct));
        }
        return positions;
    }

    public BigDecimal calcTotalPrice(List<ReceiptPosition> list) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (ReceiptPosition receiptPosition : list) {
            totalPrice = totalPrice.add(receiptPosition.getPrice().subtract(receiptPosition.getDiscount()));
        }
        return totalPrice;
    }
}
