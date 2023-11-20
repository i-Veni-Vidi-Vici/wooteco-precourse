package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static List<Integer> convertToList(String number) {
        checkNumber(number);
        List<String> splitNumbers =  List.of(number.split(""));
        List<Integer> numbers = new ArrayList<>();

        for (String splitNumber : splitNumbers) {
            numbers.add(Integer.parseInt(splitNumber));
        }

        return numbers;
    }

    private static void checkNumber(String number){
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }

}
