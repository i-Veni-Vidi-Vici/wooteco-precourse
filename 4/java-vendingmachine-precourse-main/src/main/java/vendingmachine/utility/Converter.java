package vendingmachine.utility;

import java.util.ArrayList;
import java.util.Arrays;
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

    public Map<String, List<Integer>> convertToMap(String value) {
        checkSemiColon(value);
        List<String> splitValues = Arrays.asList(value.split(";"));
        Map<String, List<Integer>> products = new HashMap<>();

        checkSquareBracket(splitValues);
        removeSquareBracket(splitValues);

        createMap(products, splitValues);

        checkDuplication(splitValues, products);
        return products;
    }

    private void createMap(Map<String, List<Integer>> products, List<String> splitValues) {
        for (String splitValue : splitValues) {
            checkComma(splitValue);
            List<String> splitProduct = Arrays.asList(splitValue.split(","));
            checkForm(splitProduct);
            checkBlank(splitProduct.get(0));

            products.put(splitProduct.get(0), convertToList(splitProduct.subList(1, splitProduct.size())));
        }
    }

    private List<Integer> convertToList(List<String> splitProduct) {
        List<Integer> priceAndCount = new ArrayList<>();

        for (String value : splitProduct) {
            priceAndCount.add(convertToNumber(value));
        }

        return priceAndCount;
    }

    private void checkBlank(String value) {
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void removeSquareBracket(List<String> values) {
        for (int index = 0; index < values.size(); index++) {
            values.set(index, values.get(index)
                    .replace("[", "").replace("]", ""));
        }
    }

    private void checkSquareBracket(List<String> splitValues) {
        for (String splitValue : splitValues) {
            checkExistenceOfSquareBracket(splitValue);
            checkOneSquareBracket(splitValue);
        }
    }

    private void checkExistenceOfSquareBracket(String value) {
        if (!(value.startsWith("[") && value.endsWith("]"))) {
            throw new IllegalArgumentException();
        }
    }

    private void checkOneSquareBracket(String value) {
        Integer count = 0;

        for (char oneLetter : value.toCharArray()) {
            if ((oneLetter == '[') || (oneLetter == ']')) {
                count++;
            }
        }

        if (count > 2) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplication(List<String> originalValues, Map<String, List<Integer>> processedValues) {
        if (originalValues.size() != processedValues.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkForm(List<String> splitMenu) {
        if (splitMenu.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void checkComma(String value) {
        if (value.endsWith(",")) {
            throw new IllegalArgumentException();
        }
    }

    private void checkSemiColon(String value) {
        if (value.endsWith(";")) {
            throw new IllegalArgumentException();
        }
    }
}
