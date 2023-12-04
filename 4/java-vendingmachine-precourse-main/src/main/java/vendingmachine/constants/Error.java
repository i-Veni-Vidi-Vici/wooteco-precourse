package vendingmachine.constants;

public enum Error {
    MONEY_ERROR("[ERROR] 금액은 10원 단위 이어야 합니다."),
    MIN_PRICE_ERROR("[ERROR] 상품 가격은 100원 이상 이어야 합니다."),
    MIN_PRICE_UNIT_ERROR("[ERROR] 상품 가격은 10원 단위 이어야 합니다."),
    PRODUCT_COUNT_ERROR("[ERROR] 상품 수량은 1개 이상 이어야 합니다."),
    PRODUCT_NONEXISTENT_ERROR("[ERROR] 존재하지 않은 상품 입니다."),
    DEFICIENT_MONEY_ERROR("[ERROR] 보유한 금액이 상품 가격보다 적습니다."),
    SOLD_OUT_ERROR("[ERROR] 해당 상품은 매진 되었습니다."),

    NUMBER_ERROR("[ERROR] 정수만 입력해 주세요."),
    FIRST_ZERO_ERROR("[ERROR] 숫자 앞에 0을 입력하지 마세요."),
    BLANK_ERROR("[ERROR] 상품명을 공백으로 입력하지 마세요."),
    FORM_ERROR("[ERROR] 양식에 맞게 입력해 주세요."),
    DUPLICATION_ERROR("[ERROR] 상품이 중복됩니다."),
    COMMA_ERROR("[ERROR] 수량 뒤에 콤마(,)를 입력하지 마세요."),
    SEMI_COLON_ERROR("[ERROR] 문자열 마지막에 세미콜론(;)를 입력하지 마세요.");

    private final String error;

    Error(String error) {
        this.error = error;
    }

    public String getMessage() {
        return error;
    }
}
