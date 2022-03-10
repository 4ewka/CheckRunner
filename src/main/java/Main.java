import model.InputData;
import model.Receipt;
import service.ArgumentsPrepareService;
import service.PrintService;
import service.ReceiptService;
import txtValidate.IdMatchCheck;
import txtValidate.ValidateBaseService;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        ValidateBaseService validateBaseService= new ValidateBaseService();
        validateBaseService.validateBase();

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
