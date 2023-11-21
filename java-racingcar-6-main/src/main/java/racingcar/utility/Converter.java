package racingcar.utility;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Converter {

    public Map<String, String> convertToMap(String value) {
        List<String> splitValues = List.of(value.split(","));
        Map<String, String> values = new LinkedHashMap<>();

        for (String splitValue : splitValues) {
            checkWhitespace(splitValue);
            values.put(splitValue, "");
        }

        checkDuplication(splitValues, values);
        return values;
    }

    private void checkWhitespace(String splitValue) {
        if (splitValue.trim().length() != splitValue.length()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplication(List<String> originalValues, Map<String, String> processedValues) {
        if (originalValues.size() != processedValues.size()) {
            throw new IllegalArgumentException();
        }
    }

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
        if ((value.length() > 1) && (value.charAt(0) == '0')) {
            throw new IllegalArgumentException();
        }
    }
}
