package service;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InputParsingService {
    private static final Logger log = Logger.getLogger(InputParsingService.class.getSimpleName());

    public int getId(String str) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) counter++;
            else break;
        }
        return Integer.parseInt(str.substring(0, counter));
    }

    public int getQuantity(String str) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) counter++;
            else break;
        }
        return Integer.parseInt(str.substring(++counter));
    }

    public int getCardNumber(String lastArg) {
        int counter = 0;
        for (int i = 0; i < lastArg.length(); i++) {
            if (Character.isDigit(lastArg.charAt(i))) {
                counter = i;
                break;
            }
        }
        if (counter == 0) {
            return 0;
        }
        return Integer.parseInt(lastArg.substring(counter));
    }

    public String[] parseArgumentsFromFile(String str) {
        File file = new File(str);
        try {
            Scanner scanner = new Scanner(file);
            if (!scanner.hasNextLine()) {
                log.log(Level.SEVERE, "File is empty");
                System.exit(0);
            }
            return scanner.nextLine().split(" ");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
