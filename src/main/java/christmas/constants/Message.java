package christmas.constants;

public enum Message {
    PLANNER("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    DATE("일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    MENU("<주문 메뉴>"),
    TOTAL_AMOUNT("<할인 전 총주문 금액>"),
    GIVEAWAY_MENU("<증정 메뉴>"),
    BENEFIT_DETAILS("<혜택 내역>"),
    TOTAL_BENEFIT_AMOUNT("<총혜택 금액>"),
    PAYMENT_AMOUNT("<할인 후 예상 결제 금액>"),
    BADGE("<12월 이벤트 배지>"),
    ONE_CHAMPAGNE("샴페인 1개"),
    DECEMBER("12월"),
    NOTHING("없음"),
    COUNT("개"),
    WON("원"),
    NEW_LINE("\n"),
    WHITESPACE(" "),
    COLON(":"),
    MINUS("-"),
    COMMA_INTEGER_FORMAT("%,d");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
