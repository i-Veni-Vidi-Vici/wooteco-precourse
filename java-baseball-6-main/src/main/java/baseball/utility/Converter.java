package baseball.utility;

import static baseball.constants.Message.EMPTY;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public List<Integer> convertToList(String number) {
        checkNumber(number);
        List<String> splitNumbers = List.of(number.split(EMPTY.getMessage()));
        List<Integer> numbers = new ArrayList<>();

        for (String splitNumber : splitNumbers) {
            numbers.add(Integer.parseInt(splitNumber));
        }

        return numbers;
    }

    private void checkNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }

    public Integer convertToNumber(String number) {
        checkNumber(number);
        return Integer.parseInt(number);
    }
}
