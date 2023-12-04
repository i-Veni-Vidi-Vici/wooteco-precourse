package vendingmachine.constants;

public enum Message {
    HAVING_MONEY_INPUT("자판기가 보유하고 있는 금액을 입력해 주세요."),
    PRODUCT_INPUT("상품명과 가격, 수량을 입력해 주세요."),
    MONEY_INPUT("투입 금액을 입력해 주세요."),
    PURCHASE_INPUT("구매할 상품명을 입력해 주세요."),

    COIN("자판기가 보유한 동전"),
    MONEY("투입 금액: "),
    CHANGE("잔돈"),

    COUNT("개"),
    WON("원");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
