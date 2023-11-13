package christmas.constants;

public enum Value {

    SPECIAL_DISCOUNT(1000),
    ZERO(0),
    INITIAL_ZERO(0),

    FIVE_WEEKS(5),

    FIRST_SPECIAL_DATE(3),

    SEVEN_DAYS(7),

    XMAS_DATE(25),


    ;




    Value(Integer value) {
        this.value = value;
    }

    private final Integer value;

    public Integer get() {
        return value;
    }

}
