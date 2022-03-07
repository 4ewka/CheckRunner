import model.InputData;
import model.Receipt;
import service.ArgumentsPrepareService;
import service.PrintService;
import service.ReceiptService;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        PrintService printService = new PrintService();
        ReceiptService receiptService = new ReceiptService();
        ArgumentsPrepareService argumentsPrepareService = new ArgumentsPrepareService();
        InputData inputData = argumentsPrepareService.createInputData(args);
        Receipt receipt = receiptService.createReceipt(inputData);
        try {
            printService.printReceipt(receipt);
        } catch (FileNotFoundException e) {
            System.out.println("File out found");
        }
    }
}
