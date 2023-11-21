package racingcar.constants;

public enum Value {

    FIRST_CHARACTER(0),
    INITIAL_ZERO(0),
    MIN_RANDOM_NUMBER(0),

    MIN_ROUND_COUNT(1),

    TWO_LENGTH(2),
    MIN_CAR_COUNT(2),

    MIN_FORWARD_CONDITION(4),
    MAX_CAR_NAME_LENGTH(5),
    MAX_RANDOM_NUMBER(9),
    ASCII_ZERO(48);

    private final Integer value;

    Value(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}
