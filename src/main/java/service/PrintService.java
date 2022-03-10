package service;

import model.Receipt;

import java.io.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Objects;

public class PrintService {

    public void printReceipt(Receipt receipt) throws FileNotFoundException {
        receiptStream(receipt, new PrintStream(new FileOutputStream("Output.txt", true)));
        receiptStream(receipt, System.out);
    }

    private void receiptStream(Receipt receipt, PrintStream out) {
        out.println("Receipt #" + ReceiptService.receiptNumber);
        streamDate(receipt.getCalendar(), out);
        streamTime(receipt.getCalendar(), out);
        out.printf("%-5s%-20s%-10s%-10s%-10s%n", "#", "Name", "Price", "Promo", "To Pay");
        for (int i = 0; i < receipt.getPositions().size(); i++) {
            out.printf("%-5d", receipt.getPositions().get(i).getCount());
            out.printf("%-20s", receipt.getPositions().get(i).getName());
            out.printf("%-10.2f", (receipt.getPositions().get(i).getPrice()));
            out.printf("%-10.2f", receipt.getPositions().get(i).getDiscount());
            out.printf("%-10.2f%n", receipt.getPositions().get(i).getTotalPrice());
        }
        out.printf("%-25s%-10.2f%n", "Total:", receipt.getTotalPrice());
        if (!Objects.equals(receipt.getPromo(), BigDecimal.ZERO)) {
            out.printf("%-25s%-10.2f%n", "Buyer card discount:", receipt.getPromo());
        }
        out.printf("%-25s%-10.2f%n", "To pay:", receipt.getToPay());
    }

    private void streamDate(Calendar calendar, PrintStream out) {
        out.printf("Date: %tD%n", calendar);
    }

    private void streamTime(Calendar calendar, PrintStream out) {
        out.printf("Time: %tT%n", calendar);
    }

    public void receiptStream(int receiptNumber) throws FileNotFoundException {
        PrintStream printStream = new PrintStream(new FileOutputStream("ReceiptNumber.txt"));
        printStream.print(++receiptNumber);
    }

    public void streamBaseValidate(String str, File file) {
        try (PrintStream printStream = new PrintStream (new FileOutputStream(file,true))) {
            printStream.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
