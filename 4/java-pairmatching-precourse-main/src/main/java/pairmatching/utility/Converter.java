package pairmatching.utility;

import static pairmatching.constants.Error.COMMA_ERROR;
import static pairmatching.constants.Symbol.COMMA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Converter {
    public List<String> convertToList(String value) {
        checkComma(value);
        List<String> values = new ArrayList<>();
        List<String> splitValues = Arrays.asList(value.split(COMMA.get()));

        for (String splitValue : splitValues) {
            values.add(splitValue.trim());
        }

        return values;
    }

    private void checkComma(String value) {
        if (value.endsWith(COMMA.get())) {
            throw new IllegalArgumentException(COMMA_ERROR.getMessage());
        }
    }
}
