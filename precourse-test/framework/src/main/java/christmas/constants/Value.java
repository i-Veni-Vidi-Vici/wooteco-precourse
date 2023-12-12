package christmas.constants;

public enum Value {
    ZERO(0),
    FIRST_CHARACTER(0),
    INITIAL_ZERO(0),
    TWO_LENGTH(2),
    ASCII_ZERO(48),


    FIRST_INDEX(0),
    SECOND_INDEX(1),
    TWO_SIZE(2),
    ;

    private final Integer value;

    Value(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}
