package christmas.constants;

public enum Value {
    ZERO(0),
    FIRST_CHARACTER(0),
    INITIAL_ZERO(0),
//    REMAINDER_ZERO(0),
//
//    ONE(1),

    FIRST_INDEX(0),
    SECOND_INDEX(1),
    TWO_LENGTH(2),
    TWO_SIZE(2),
//    MIN_MATCHING_COUNT(3),
    ASCII_ZERO(48),
//    PERCENT(100),
//    THOUSAND_WON(1000);

    MAX_TOTAL_COUNT(20),

    MIN_MENU_COUNT(1),
    ;

    private final Integer value;

    Value(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}
