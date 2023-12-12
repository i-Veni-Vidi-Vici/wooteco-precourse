package christmas.constants;

public enum Value {
    ZERO(0),
    FIRST_CHARACTER(0),
    INITIAL_ZERO(0),
    FIRST_INDEX(0),

    MIN_FOOD_COUNT(1),
    ONE_LENGTH(1),
    SECOND_INDEX(1),
    MENU_VIEW_OPTION(1),

    FORM_SIZE(2),
    MENU_SKIP_OPTION(2),

    MAX_TOTAL_FOOD_COUNT(20),
    ASCII_ZERO(48);

    private final Integer value;

    Value(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}
