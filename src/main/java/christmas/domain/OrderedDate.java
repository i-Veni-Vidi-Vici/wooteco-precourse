package christmas.domain;

public class OrderedDate {

    private final Integer date;

    public OrderedDate(Integer date) {
        checkRange(date);
        this.date = date;
    }

    public static void checkRange(Integer date) {
        if ((date < 1) || (date > 31)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
