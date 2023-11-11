package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constants.Food;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputView {

    public static String getDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        return Console.readLine();
    }

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

    public static String getOrder() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        return Console.readLine();
    }

    private static List<String> convertToList(String userInput) {
        return Arrays.asList(userInput.split(","));
    }

    public static Map<String, Integer> convertToMap(String userInput) {
        Map<String, Integer> menu = new HashMap<>();
        List<String> inputs = convertToList(userInput);

        for (String input : inputs) {
            String[] separatedInput = input.split("-");
            checkMenu(separatedInput[0]);
            menu.put(separatedInput[0], convertToNumber(separatedInput[1],
                    "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."));
        }

        checkDuplication(inputs, menu);
        return menu;
    }

    public static void checkMenu(String userInput) {
        for (Food food : Food.values()) {
            if (food.getName().equals(userInput)) {
                return;
            }
        }

        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    private static void checkDuplication(List<String> inputs, Map<String,Integer> menu) {
        if(inputs.size() != menu.size()){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

}
