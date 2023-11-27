package christmas.utility;

import static christmas.constants.Symbol.COMMA;
import static christmas.constants.Symbol.HYPHEN;
import static christmas.constants.Value.ASCII_ZERO;
import static christmas.constants.Value.FIRST_CHARACTER;
import static christmas.constants.Value.FIRST_INDEX;
import static christmas.constants.Value.SECOND_INDEX;
import static christmas.constants.Value.TWO_LENGTH;
import static christmas.constants.Value.TWO_SIZE;

import christmas.constants.Food;
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
        if ((value.length() >= TWO_LENGTH.get()) && (value.charAt(FIRST_CHARACTER.get()) == ASCII_ZERO.get())) {
            throw new IllegalArgumentException();
        }
    }

    public Map<Food, Integer> convertToMap(String value) {
        checkComma(value);
        List<String> splitValues = List.of(value.split(COMMA.get()));
        Map<Food, Integer> menu = new HashMap<>();

        for (String splitValue : splitValues) {
            List<String> splitMenu = List.of(splitValue.split(HYPHEN.get()));
            checkForm(splitMenu);
            menu.put(checkMenu(splitMenu), convertToNumber(splitMenu.get(SECOND_INDEX.get())));
        }

        checkDuplication(splitValues, menu);
        return menu;
    }

    private void checkDuplication(List<String> splitValues, Map<Food, Integer> menu) {
        if (splitValues.size() != menu.size()) {
            throw new IllegalArgumentException();
        }
    }

    private Food checkMenu(List<String> splitMenu) {
        for (Food food : Food.values()) {
            if (splitMenu.get(FIRST_INDEX.get()).equals(food.getName())) {
                return food;
            }
        }

        throw new IllegalArgumentException();
    }

    private void checkForm(List<String> splitMenu) {
        if (splitMenu.size() != TWO_SIZE.get()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkComma(String value) {
        if (value.endsWith(COMMA.get())) {
            throw new IllegalArgumentException();
        }
    }
}
