package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReceiptNumberService {
    public int getLastNumber() {
        File file = new File("ReceiptNumber.txt");
        int i = 0;
        try {
            Scanner scanner = new Scanner(file);
            if (scanner.hasNextInt()) {
                i = scanner.nextInt();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        PrintService printService = new PrintService();
        try {
            printService.receiptStream(i);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return i;
    }
}
