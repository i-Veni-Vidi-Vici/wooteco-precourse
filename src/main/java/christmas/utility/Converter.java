package christmas.utility;

import christmas.constants.Food;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Converter {


    public static Integer convertToNumber(String value) {
        checkNumber(value);
        return Integer.parseInt(value);
    }

    private static void checkNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
    }

    private static List<String> convertToListByComma(String value) {
        return Arrays.asList(value.split(","));
    }

    public static Map<Food, Integer> convertToOrderedMenu(String value) {
        Map<String, Integer> menu = new HashMap<>();
        List<String> inputs = convertToListByComma(value);

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
