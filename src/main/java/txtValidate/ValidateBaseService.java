package txtValidate;

import constants.PathConstant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ValidateBaseService {

    public static final String REGEX = "^([1-9][0-9]?|100);[A-Z]\\w{2,29};([1-9]\\d?\\.\\d{2}|100.00);[yn]$";

    public void validateBase() {

        File base = new File(PathConstant.BASE);
        File validBase = new File(PathConstant.VALID_BASE);
        File invalidBase = new File(PathConstant.INVALID_BASE);
        String str;
        try (Scanner scanner = new Scanner(base);
             PrintStream validBaseStream = new PrintStream(new FileOutputStream(validBase, false));
             PrintStream invalidBaseStream = new PrintStream(new FileOutputStream(invalidBase, false))) {
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
                if (str.matches(REGEX)) {
                    validBaseStream.println(str);
                } else {
                    invalidBaseStream.println(str);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
