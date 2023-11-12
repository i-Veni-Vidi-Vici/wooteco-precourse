package christmas.utility;

import christmas.constants.Food;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Converter {


    public static Integer convertToNumber(String value) {
        checkNumber(value);
        checkZero(value);
        return Integer.parseInt(value);
    }

    private static void checkNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkZero(String value) {
        if ((value.charAt(0) == '0') && (value.length() > 1)) {
            throw new IllegalArgumentException();
        }
    }

    public static Map<Food, Integer> convertToOrderedMenu(String value) {
        Map<Food, Integer> orderedMenu = new HashMap<>();
        List<String> inputMenus = convertToList(value, ",");

        for (String inputMenu : inputMenus) {
            List<String> foodAndPrice = convertToList(inputMenu, "-");
            checkSize(foodAndPrice);
            orderedMenu.put(Food.checkExistence(foodAndPrice.get(0)), convertToNumber(foodAndPrice.get(1)));
        }

        checkDuplication(inputMenus, orderedMenu);
        return orderedMenu;
    }

    private static List<String> convertToList(String value, String delimiter) {
        return Arrays.asList(value.split(delimiter));
    }

    private static void checkSize(List<String> foodAndPrice) {
        if (foodAndPrice.size() != 2) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void checkDuplication(List<String> inputMenus, Map<Food, Integer> menu) {
        if (inputMenus.size() != menu.size()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
