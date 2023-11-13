package christmas.utility;

import static christmas.constants.Message.COMMA;
import static christmas.constants.Message.HYPHEN;
import static christmas.constants.Value.ASCII_ZERO;
import static christmas.constants.Value.FIRST_CHARACTER;
import static christmas.constants.Value.FIRST_INDEX;
import static christmas.constants.Value.FORM_SIZE;
import static christmas.constants.Value.ONE_LENGTH;
import static christmas.constants.Value.SECOND_INDEX;

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
        if ((value.charAt(FIRST_CHARACTER.get()) == ASCII_ZERO.get()) && (value.length() > ONE_LENGTH.get())) {
            throw new IllegalArgumentException();
        }
    }

    public static Map<Food, Integer> convertToReservedMenu(String value) {
        Map<Food, Integer> orderedMenu = new HashMap<>();
        List<String> inputMenus = convertToList(value, COMMA.getMessage());

        for (String inputMenu : inputMenus) {
            List<String> foodAndPrice = convertToList(inputMenu, HYPHEN.getMessage());
            checkForm(foodAndPrice);
            orderedMenu.put(Food.checkExistence(foodAndPrice.get(FIRST_INDEX.get())),
                    convertToNumber(foodAndPrice.get(SECOND_INDEX.get())));
        }

        checkDuplication(inputMenus, orderedMenu);
        return orderedMenu;
    }

    private static List<String> convertToList(String value, String delimiter) {
        return Arrays.asList(value.split(delimiter));
    }

    private static void checkForm(List<String> foodAndPrice) {
        if (foodAndPrice.size() != FORM_SIZE.get()) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkDuplication(List<String> inputMenus, Map<Food, Integer> menu) {
        if (inputMenus.size() != menu.size()) {
            throw new IllegalArgumentException();
        }
    }
}
