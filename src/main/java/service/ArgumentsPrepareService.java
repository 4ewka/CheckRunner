package service;

import model.InputData;
import model.InputProduct;

import java.util.ArrayList;
import java.util.List;

public class ArgumentsPrepareService {
    public InputData createInputData(String[] args) {
        InputData inputData = new InputData();
        InputParsingService inputParsingService = new InputParsingService();
        InputVerification inputVerification = new InputVerification();
        if (inputVerification.isFile(args)) {
            args = createArgsFromFile(args);
        }
        inputVerification.validateInputString(args);
        inputData.setInputProducts(createInputProducts(args));
        if (inputVerification.containsCard(args)) {
            inputData.setCardNumber(inputParsingService.getCardNumber(args[args.length - 1]));
        } else {
            inputData.setCardNumber(null);
        }
        return inputData;
    }

    public List<InputProduct> createInputProducts(String[] args) {
        List<InputProduct> list = new ArrayList<>();
        InputVerification inputVerification = new InputVerification();
        int n = args.length;
        if (inputVerification.containsCard(args)) {
            n--;
        }
        for (int i = 0; i < n; i++) {
            list.add(createInputProduct(args[i]));
        }
        return list;
    }

    public InputProduct createInputProduct(String args) {
        InputParsingService inputParsingService = new InputParsingService();
        return new InputProduct(inputParsingService.getId(args), inputParsingService.getQuantity(args));
    }

    public String[] createArgsFromFile(String[] args) {
        InputVerification inputVerification = new InputVerification();
        InputParsingService inputParsingService = new InputParsingService();
        inputVerification.checkArgsLength(args);
        args = inputParsingService.parseArgumentsFromFile(args[0]);
        inputVerification.validateInputString(args);
        return args;
    }
}
