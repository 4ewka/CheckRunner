package txtValidate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class IdMatchCheck {
    public boolean checkMatch() throws IOException {
        File file = new File("src/main/resources/base.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<Integer> ids = new ArrayList<>();
        int i = 0, interm;
        while (scanner.hasNextLine()) {
            interm = parseId(scanner.nextLine());
            for (int j = 0; j < i; j++) {
                if (ids.get(j) == interm) {
                    System.out.println("IDs are repeated - check base.txt");
                    System.exit(0);
                }
            }
            ids.add(interm);
            i++;
        }
        for (int k : ids) {
            System.out.println(k);
        }
        return true;
    }

    private int parseId(String string) {
        int i = 0;
        while (Character.isDigit(string.charAt(i))) {
            i++;
        }
        return Integer.parseInt(string.substring(0, i));
    }
}

