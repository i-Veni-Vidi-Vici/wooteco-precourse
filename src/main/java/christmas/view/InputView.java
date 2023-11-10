package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        return Console.readLine();
    }

    public static Integer convertToNumber(String userInput) {
        checkNumber(userInput);
        return Integer.parseInt(userInput);
    }

    private static void checkNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public static void checkZero(String userInput) {
        if(userInput.charAt(0) == '0'){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public static void checkRange(Integer userInput) {
        if ((userInput < 1) || (userInput > 31)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }


}
