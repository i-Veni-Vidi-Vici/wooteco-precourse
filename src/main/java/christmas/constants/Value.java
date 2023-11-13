package christmas.constants;

public enum Value {

    SPECIAL_DISCOUNT(1000),
    ZERO(0),
    INITIAL_ZERO(0),

    FIVE_WEEKS(5),

    FIRST_SPECIAL_DATE(3),

    FIRST_WEEKDAY_DATE(3),

    FIRST_WEEK_LAST_WEEKDAY_DATE(7),

    SEVEN_DAYS(7),

    XMAS_DATE(25),

    WEEKDAY_DISCOUNT(2023),
    WEEKEND_DISCOUNT(2023),
    FIRST_WEEKEND_DATE(1),
    FIRST_WEEK_LAST_WEEKEND_DATE(2),

    FIRST_XMAS_DISCOUNT(1000),

    ONE_DATE(1),

    XMAS_INCREMENT_DISCOUNT(100),

    CHAMPAGNE_PRICE(25000),

    MINIMUM_PRICE_CONDITION(120000)

    ;




    Value(Integer value) {
        this.value = value;
    }

    private final Integer value;

    public Integer get() {
        return value;
    }

}
