package christmas.constants;

public enum Value {
    ZERO(0),
    FIRST_CHARACTER(0),
    INITIAL_ZERO(0),
    FIRST_INDEX(0),

    ONE_DATE(1),
    MIN_FOOD_COUNT(1),
    MIN_DATE(1),
    FIRST_WEEKEND_DATE(1),
    ONE_LENGTH(1),
    SECOND_INDEX(1),

    FORM_SIZE(2),
    FIRST_WEEK_LAST_WEEKEND_DATE(2),

    FIRST_SPECIAL_DATE(3),
    FIRST_WEEKDAY_DATE(3),

    FIVE_WEEKS(5),

    SEVEN_DAYS(7),
    FIRST_WEEK_LAST_WEEKDAY_DATE(7),


    MAX_TOTAL_FOOD_COUNT(20),
    XMAS_DATE(25),
    MAX_DATE(31),
    ASCII_ZERO(48),
    XMAS_INCREMENT_DISCOUNT(100),

    SPECIAL_DISCOUNT(1000),
    FIRST_XMAS_DISCOUNT(1000),

    WEEKDAY_DISCOUNT(2023),
    WEEKEND_DISCOUNT(2023),

    BENEFIT_MIN_AMOUNT_CONDITION(10000),
    CHAMPAGNE_PRICE(25000),
    GIVEAWAY_MIN_AMOUNT_CONDITION(120000);

    private final Integer value;

    Value(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}
