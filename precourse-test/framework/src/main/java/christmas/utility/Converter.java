package christmas.utility;

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

    // 리스트로 변환
    public List<Integer> convertToList(String value) {
        checkComma(value);
        List<Integer> numbers = new ArrayList<>();
        List<String> splitValues = List.of(value.split(","));

        for (String splitValue : splitValues) {
            numbers.add(convertToNumber(splitValue));
        }

        return numbers;
    }

    private void checkComma(String value) {
        if (value.endsWith(",")) {
            throw new IllegalArgumentException();
        }
    }


    // a-1,b-1  => {"a", 1 ,"b",1} Map String 변환필요
    public Map<String, Integer> convertToMap(String value) {
        checkComma(value);
        List<String> splitValues = List.of(value.split(","));
        Map<String, Integer> menu = new HashMap<>();

        for (String splitValue : splitValues) {
            List<String> splitMenu = List.of(splitValue.split("-"));
            checkForm(splitMenu);
            menu.put(checkExistence(splitMenu.get(0)), convertToNumber(splitMenu.get(1)));
        }

        checkDuplication(splitValues, menu);
        return menu;
    }

    private void checkDuplication(List<String> originalValues, Map<String, Integer> processedValues) {
        if (originalValues.size() != processedValues.size()) {
            throw new IllegalArgumentException();
        }
    }

    private String checkExistence(String orderedFood) {
        for (String food : Food.values()) {
            if (food.getName().equals(orderedFood)) {
                return food;
            }
        }

        throw new IllegalArgumentException();
    }

    private void checkForm(List<String> splitMenu) {
        if (splitMenu.size() != 2) {
            throw new IllegalArgumentException();
        }
    }

}
