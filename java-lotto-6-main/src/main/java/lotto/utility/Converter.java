package lotto.utility;

import static lotto.constants.ERROR.COMMA_ERROR;
import static lotto.constants.ERROR.FIRST_ZERO_ERROR;
import static lotto.constants.ERROR.NOT_INTEGER_ERROR;
import static lotto.constants.Symbol.COMMA;
import static lotto.constants.Value.ASCII_ZERO;
import static lotto.constants.Value.FIRST_CHARACTER;
import static lotto.constants.Value.TWO_LENGTH;

import java.util.ArrayList;
import java.util.List;

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
            throw new IllegalArgumentException(NOT_INTEGER_ERROR.getMessage());
        }
    }

    private void checkFirstZero(String value) {
        if ((value.length() >= TWO_LENGTH.get()) && (value.charAt(FIRST_CHARACTER.get()) == ASCII_ZERO.get())) {
            throw new IllegalArgumentException(FIRST_ZERO_ERROR.getMessage());
        }
    }

    public List<Integer> convertToList(String value) {
        checkComma(value);
        List<Integer> numbers = new ArrayList<>();
        List<String> splitValues = List.of(value.split(COMMA.get()));

        for (String splitValue : splitValues) {
            numbers.add(convertToNumber(splitValue));
        }

        return numbers;
    }

    private void checkComma(String value) {
        if (value.endsWith(COMMA.get())) {
            throw new IllegalArgumentException(COMMA_ERROR.getMessage());
        }
    }
}
