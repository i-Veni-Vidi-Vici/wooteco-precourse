package christmas.constants;

public enum DiscountValue {
    XMAS_INCREASE_DISCOUNT(100),

    FIRST_XMAS_DISCOUNT(1_000),
    SPECIAL_DISCOUNT(1_000),

    WEEKDAY_DISCOUNT(2_023),
    WEEKEND_DISCOUNT(2_023),

    MIN_BENEFIT_CONDITION(10_000),
    MIN_AMOUNT_OF_GIVEAWAY_CONDITION(120_000);

    private final Integer discountValue;

    DiscountValue(Integer discountValue) {
        this.discountValue = discountValue;
    }

    public Integer get() {
        return discountValue;
    }
}
