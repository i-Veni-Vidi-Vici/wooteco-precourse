package vendingmachine.constants;

public enum Value {
    FIRST_CHARACTER(0),
    INITIAL_ZERO(0),
    REMAINDER_ZERO(0),
    PRODUCT_COUNT_ZERO(0),
    FIRST_INDEX(0),

    SECOND_INDEX(1),
    ONE(1),

    TWO_LENGTH(2),
    FORM_SIZE(3),
    ASCII_ZERO(48),

    MIN_MONEY_UNIT(10),
    MON_PRICE_UNIT(10),

    MIN_PRICE(100);

    private final Integer value;

    Value(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}
