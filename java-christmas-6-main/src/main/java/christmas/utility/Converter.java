package christmas.utility;

import christmas.constants.Food;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Converter {
    public Integer convertToNumber(String value) {
        checkNumber(value);
        checkFirstZero(value);
        return Integer.parseInt(value);
    }

    private void checkNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
    }

    private void checkFirstZero(String value) {
        if ((value.length() >= 2) && (value.charAt(0) == '0')) {
            throw new IllegalArgumentException();
        }
    }

    public Map<Food, Integer> convertToMap(String value) {
        checkComma(value);
        List<String> splitValues = List.of(value.split(","));
        Map<Food, Integer> menu = new HashMap<>();

        for (String splitValue : splitValues) {
            List<String> splitMenu = List.of(splitValue.split("-"));
            checkForm(splitMenu);
            menu.put(checkMenu(splitMenu), convertToNumber(splitMenu.get(1)));
        }

        checkDuplication(splitValues, menu);
        return menu;
    }

    private void checkDuplication(List<String> splitValues, Map<Food, Integer> menu){
        if (splitValues.size() != menu.size()) {
            throw new IllegalArgumentException();
        }
    }

    private Food checkMenu(List<String> splitMenu){
        for (Food food : Food.values()) {
            if (splitMenu.get(0).equals(food.getName())) {
                return food;
            }
        }

        throw new IllegalArgumentException();
    }

    private void checkForm(List<String> splitMenu){
        if (splitMenu.size() != 2) {
            throw new IllegalArgumentException();
        }
    }

    private void checkComma(String value) {
        if (value.endsWith(",")) {
            throw new IllegalArgumentException();
        }
    }
}
