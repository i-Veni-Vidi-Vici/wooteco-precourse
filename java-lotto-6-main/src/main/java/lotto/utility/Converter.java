package lotto.utility;

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
            throw new IllegalArgumentException();
        }
    }

    private void checkFirstZero(String value) {
        if ((value.length() >= 2) && (value.charAt(0) == '0')) {
            throw new IllegalArgumentException();
        }
    }

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
}
