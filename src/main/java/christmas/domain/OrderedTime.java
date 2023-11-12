package christmas.domain;

public class OrderedTime {

    public static void checkRange(Integer userInput) {
        if ((userInput < 1) || (userInput > 31)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
