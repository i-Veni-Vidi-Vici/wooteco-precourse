package christmas.constants;

public enum DateValue {
    ONE_DATE(1),
    MIN_DATE(1),
    FIRST_WEEKEND_DATE(1),

    FIRST_WEEK_LAST_WEEKEND_DATE(2),

    FIRST_SPECIAL_DATE(3),
    FIRST_WEEKDAY_DATE(3),

    FIVE_WEEKS(5),

    SEVEN_DAYS(7),
    FIRST_WEEK_LAST_WEEKDAY_DATE(7),

    XMAS_DATE(25),
    MAX_DATE(31);

    private final Integer dateValue;

    DateValue(Integer dateValue) {
        this.dateValue = dateValue;
    }

    public Integer get() {
        return dateValue;
    }
}
