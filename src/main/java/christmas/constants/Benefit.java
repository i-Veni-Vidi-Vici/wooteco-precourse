package christmas.constants;

public enum Benefit {

    CHRISTMAS("크리스마스 디데이 할인"),
    WEEKDAY("평일 할인"),
    WEEKEND("주말 할인"),
    SPECIAL("특별 할인"),
    FREE_GIFT("증정 이벤트");

    private final String benefit;

    Benefit(String benefit) {
        this.benefit = benefit;
    }

    public String getBenefit() {
        return benefit;
    }
}
