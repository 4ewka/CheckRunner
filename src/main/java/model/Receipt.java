package model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Receipt {
    private List<ReceiptPosition> positions;
    private BigDecimal totalPrice;
    private BigDecimal promo;
    private BigDecimal toPay;
    private GregorianCalendar calendar;

    public Calendar getCalendar() {
        return calendar;
    }

    public void setDate() {
        this.calendar = new GregorianCalendar();
    }

    public BigDecimal getToPay() {
        return toPay;
    }

    public void setToPay(BigDecimal toPay) {
        this.toPay = toPay;
    }

    public List<ReceiptPosition> getPositions() {
        return positions;
    }

    public void setPositions(List<ReceiptPosition> positions) {
        this.positions = positions;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getPromo() {
        return promo;
    }

    public void setPromo(BigDecimal promo) {
        this.promo = promo;
    }
}
