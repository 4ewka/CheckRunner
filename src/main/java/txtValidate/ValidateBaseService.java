package txtValidate;

import service.PrintService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ValidateBaseService {
    public void validateBase(){
        File file = new File("src/main/resources/base.txt");
        PrintService printService= new PrintService();
        String str;
        String regex = "^\\d\\d?0?;[A-Z]\\w{2,30};\\d+.\\d{2};[yn]$";
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                str= scanner.nextLine();
                if (str.matches(regex)){
                    printService.streamBaseValidate(str,new File("src/main/resources/validBase.txt"));
                }else {
                    printService.streamBaseValidate(str,new File("src/main/resources/invalidBase.txt"));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
