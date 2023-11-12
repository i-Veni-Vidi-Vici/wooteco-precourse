package christmas.domain;

public class ReservedDate {

    private final Integer reservedDate;

    public ReservedDate(Integer reservedDate) {
        checkRange(reservedDate);
        this.reservedDate = reservedDate;
    }

    public static void checkRange(Integer date) {
        if ((date < 1) || (date > 31)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public Integer getDate() {
        return reservedDate;
    }
}
