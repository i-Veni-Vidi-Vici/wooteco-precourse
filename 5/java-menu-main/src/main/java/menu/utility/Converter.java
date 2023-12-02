package menu.utility;

import static menu.constants.Error.COMMA_ERROR;
import static menu.constants.Symbol.COMMA;

import java.util.List;

public class Converter {
    public List<String> convertToList(String value) {
        checkComma(value);
        return List.of(value.split(COMMA.get()));
    }

    private void checkComma(String value) {
        if (value.endsWith(COMMA.get())) {
            throw new IllegalArgumentException(COMMA_ERROR.getMessage());
        }
    }
}
