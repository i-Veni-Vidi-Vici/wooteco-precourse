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
            throw new IllegalArgumentException("[ERROR] 정수가 아닙니다.");
        }
    }

    private void checkFirstZero(String value) {
        if ((value.length() >= 2) && (value.charAt(0) == '0')) {
            throw new IllegalArgumentException("[ERROR] 숫자 앞에 0이 존재합니다.");
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
            throw new IllegalArgumentException("[ERROR] 마지막에 콤마가 존재합니다.");
        }
    }
}
