package lotto.constants;

public enum Value {
    ZERO(0),
    FIRST_CHARACTER(0),
    INITIAL_ZERO(0),
    REMAINDER_ZERO(0),

    ONE(1),
    TWO_LENGTH(2),
    MIN_MATCHING_COUNT(3),
    ASCII_ZERO(48),
    PERCENT(100),
    THOUSAND_WON(1000);

    private final Integer value;

    Value(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}
