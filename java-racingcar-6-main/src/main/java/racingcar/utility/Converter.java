package racingcar.utility;

import static racingcar.constants.Symbol.COMMA;
import static racingcar.constants.Symbol.EMPTY;
import static racingcar.constants.Value.ASCII_ZERO;
import static racingcar.constants.Value.FIRST_CHARACTER;
import static racingcar.constants.Value.TWO_LENGTH;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Converter {

    public Map<String, String> convertToMap(String value) {
        checkComma(value);
        List<String> splitValues = List.of(value.split(COMMA.get()));
        Map<String, String> values = new LinkedHashMap<>();

        for (String splitValue : splitValues) {
            checkWhitespace(splitValue);
            values.put(splitValue, EMPTY.get());
        }

        checkDuplication(splitValues, values);
        return values;
    }

    private void checkComma(String value){
        if (value.endsWith(COMMA.get())) {
            throw new IllegalArgumentException();
        }
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
        if ((value.length() >= TWO_LENGTH.get()) && (value.charAt(FIRST_CHARACTER.get()) == ASCII_ZERO.get())) {
            throw new IllegalArgumentException();
        }
    }
}
