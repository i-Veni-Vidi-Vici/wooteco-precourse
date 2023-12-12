package vendingmachine.utility;

import static vendingmachine.constants.Error.BLANK_ERROR;
import static vendingmachine.constants.Error.COMMA_ERROR;
import static vendingmachine.constants.Error.DUPLICATION_ERROR;
import static vendingmachine.constants.Error.FIRST_ZERO_ERROR;
import static vendingmachine.constants.Error.FORM_ERROR;
import static vendingmachine.constants.Error.NUMBER_ERROR;
import static vendingmachine.constants.Error.SEMI_COLON_ERROR;
import static vendingmachine.constants.Symbol.COMMA;
import static vendingmachine.constants.Symbol.EMPTY;
import static vendingmachine.constants.Symbol.LEFT_SQUARE_BRACKET;
import static vendingmachine.constants.Symbol.RIGHT_SQUARE_BRACKET;
import static vendingmachine.constants.Symbol.SEMI_COLON;
import static vendingmachine.constants.Value.ASCII_ZERO;
import static vendingmachine.constants.Value.FIRST_CHARACTER;
import static vendingmachine.constants.Value.FIRST_INDEX;
import static vendingmachine.constants.Value.FORM_SIZE;
import static vendingmachine.constants.Value.SECOND_INDEX;
import static vendingmachine.constants.Value.TWO_LENGTH;

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
            throw new IllegalArgumentException(NUMBER_ERROR.getMessage());
        }
    }

    private void checkFirstZero(String value) {
        if ((value.length() >= TWO_LENGTH.get()) && (value.charAt(FIRST_CHARACTER.get()) == ASCII_ZERO.get())) {
            throw new IllegalArgumentException(FIRST_ZERO_ERROR.getMessage());
        }
    }

    public Map<String, List<Integer>> convertToMap(String value) {
        checkSemiColon(value);
        List<String> splitValues = Arrays.asList(value.split(SEMI_COLON.get()));
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
            List<String> splitProduct = Arrays.asList(splitValue.split(COMMA.get()));
            checkForm(splitProduct);
            checkBlank(splitProduct.get(FIRST_INDEX.get()));

            products.put(splitProduct.get(FIRST_INDEX.get()),
                    convertToList(splitProduct.subList(SECOND_INDEX.get(), splitProduct.size())));
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
            throw new IllegalArgumentException(BLANK_ERROR.getMessage());
        }
    }

    private void removeSquareBracket(List<String> values) {
        for (int index = 0; index < values.size(); index++) {
            values.set(index, values.get(index)
                    .replace(LEFT_SQUARE_BRACKET.get(), EMPTY.get()).replace(RIGHT_SQUARE_BRACKET.get(), EMPTY.get()));
        }
    }

    private void checkSquareBracket(List<String> splitValues) {
        for (String splitValue : splitValues) {
            checkExistenceOfSquareBracket(splitValue);
            checkOneSquareBracket(splitValue);
        }
    }

    private void checkExistenceOfSquareBracket(String value) {
        if (!(value.startsWith(LEFT_SQUARE_BRACKET.get()) && value.endsWith(RIGHT_SQUARE_BRACKET.get()))) {
            throw new IllegalArgumentException(FORM_ERROR.getMessage());
        }
    }

    private void checkOneSquareBracket(String value) {
        Integer count = 0;

        for (String oneLetter : value.split(EMPTY.get())) {
            if ((oneLetter.equals(LEFT_SQUARE_BRACKET.get())) || (oneLetter.equals(RIGHT_SQUARE_BRACKET.get()))) {
                count++;
            }
        }

        if (count > 2) {
            throw new IllegalArgumentException(FORM_ERROR.getMessage());
        }
    }

    private void checkDuplication(List<String> originalValues, Map<String, List<Integer>> processedValues) {
        if (originalValues.size() != processedValues.size()) {
            throw new IllegalArgumentException(DUPLICATION_ERROR.getMessage());
        }
    }

    private void checkForm(List<String> splitMenu) {
        if (splitMenu.size() != FORM_SIZE.get()) {
            throw new IllegalArgumentException(FORM_ERROR.getMessage());
        }
    }

    private void checkComma(String value) {
        if (value.endsWith(COMMA.get())) {
            throw new IllegalArgumentException(COMMA_ERROR.getMessage());
        }
    }

    private void checkSemiColon(String value) {
        if (value.endsWith(SEMI_COLON.get())) {
            throw new IllegalArgumentException(SEMI_COLON_ERROR.getMessage());
        }
    }
}
