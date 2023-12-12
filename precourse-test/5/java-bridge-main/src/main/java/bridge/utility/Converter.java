package bridge.utility;

import static bridge.constants.Error.FIRST_ZERO_ERROR;
import static bridge.constants.Error.NUMBER_ERROR;
import static bridge.constants.Value.ASCII_ZERO;
import static bridge.constants.Value.FIRST_CHARACTER;
import static bridge.constants.Value.TWO_LENGTH;

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
}
