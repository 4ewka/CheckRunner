package model;

import java.util.List;

public class InputData {

    private List<InputProduct> inputProducts;
    private Integer cardNumber;

    public List<InputProduct> getInputProducts() {
        return inputProducts;
    }

    public void setInputProducts(List<InputProduct> inputProducts) {
        this.inputProducts = inputProducts;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }
}
