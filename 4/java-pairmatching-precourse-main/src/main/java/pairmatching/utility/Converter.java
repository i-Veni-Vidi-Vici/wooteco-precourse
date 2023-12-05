package pairmatching.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Converter {
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
