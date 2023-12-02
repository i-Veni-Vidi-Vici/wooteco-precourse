package menu.utility;

import java.util.List;

public class Converter {
    public List<String> convertToList(String value) {
        checkComma(value);
        return List.of(value.split(","));
    }

    private void checkComma(String value) {
        if (value.endsWith(",")) {
            throw new IllegalArgumentException();
        }
    }
}
