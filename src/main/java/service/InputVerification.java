package service;


import java.util.logging.Level;
import java.util.logging.Logger;

public class InputVerification {
    private static final Logger log = Logger.getLogger(InputVerification.class.getSimpleName());

    public Boolean containsCard(String[] arr) {
        return arr[arr.length - 1].toLowerCase().contains("card");
    }

    public void checkArgsLength(String[] arr) {
        if (arr.length == 0) {
            log.log(Level.SEVERE, "No arguments were passed");
            System.exit(0);
        }
    }

    public void validateInputString(String[] arr) {
        InputParsingService inputParsingService = new InputParsingService();
        int n = arr.length;
        if (containsCard(arr)) n--;
        checkArgsLength(arr);
        for (int i = 0; i < n; i++) {
            if (!arr[i].matches("\\d+-\\d+")) {
                log.log(Level.SEVERE, "Invalid input format");
                System.exit(0);
            }
            if (inputParsingService.getId(arr[i]) > n) {
                log.log(Level.SEVERE, "ID not found");
                System.exit(0);
            }
        }
    }

    public Boolean isFile(String[] args) {
        checkArgsLength(args);
        if (args.length > 1) return false;
        return args[0].contains(".txt");
    }
}
