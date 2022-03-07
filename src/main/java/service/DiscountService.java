package service;

import base.CardBase;
import model.InputData;
import model.Receipt;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DiscountService {
    public BigDecimal setDiscount(InputData inputData, Receipt receipt) {
        if (inputData.getCardNumber() == null) {
            return BigDecimal.ZERO;
        } else {
            CardBase cardBase = new CardBase();
            if (cardBase.checkCardNumber(inputData.getCardNumber())) {
                return (receipt.getTotalPrice().multiply(BigDecimal.valueOf(0.1)).setScale(2, RoundingMode.HALF_UP));
            }
        }
        return BigDecimal.ZERO;
    }
}
