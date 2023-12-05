package pairmatching.utility;

import java.util.ArrayList;
import java.util.Arrays;
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

    public List<String> convertToList(String value) {
        checkComma(value);
        List<String> values = new ArrayList<>();
        List<String> splitValues = Arrays.asList(value.split(","));

        for (String splitValue : splitValues) {
            values.add(splitValue.trim());
        }

        return values;
    }

    private void checkComma(String value) {
        if (value.endsWith(",")) {
            throw new IllegalArgumentException();
        }
    }
}
