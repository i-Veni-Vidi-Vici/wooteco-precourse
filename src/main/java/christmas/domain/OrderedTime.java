package christmas.domain;

public class OrderedTime {

    public static Integer convertToNumber(String userInput, String exceptionMessage) {
        checkNumber(userInput, exceptionMessage);
        return Integer.parseInt(userInput);
    }

    private static void checkNumber(String userInput, String exceptionMessage) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public static void checkZero(String userInput) {
        if (userInput.charAt(0) == '0') {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public static void checkRange(Integer userInput) {
        if ((userInput < 1) || (userInput > 31)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
