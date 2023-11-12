package christmas.utility;


import christmas.constants.Food;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Converter {


    public static Integer convertToNumber(String userInput, String exceptionMessage) {
        checkNumber(userInput, exceptionMessage);
        return Integer.parseInt(userInput);
    }

    private static void checkNumber(String userInput, String exceptionMessage) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private static List<String> convertToList(String userInput) {
        return Arrays.asList(userInput.split(","));
    }

    public static Map<String, Integer> convertToMap(String userInput) {
        Map<String, Integer> menu = new HashMap<>();
        List<String> inputs = convertToList(userInput);

        for (String input : inputs) {
            String[] separatedInput = input.split("-");
            Food.checkExistence(separatedInput[0]);
            menu.put(separatedInput[0], convertToNumber(separatedInput[1],
                    "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."));
        }

        checkDuplication(inputs, menu);
        return menu;
    }

    private static void checkDuplication(List<String> inputs, Map<String,Integer> menu) {
        if(inputs.size() != menu.size()){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
