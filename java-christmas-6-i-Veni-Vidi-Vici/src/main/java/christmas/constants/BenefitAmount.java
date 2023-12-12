package christmas.constants;

public enum BenefitAmount {
    XMAS_INCREMENT_DISCOUNT(100),

    SPECIAL_DISCOUNT(1000),
    FIRST_XMAS_DISCOUNT(1000),

    WEEKDAY_DISCOUNT(2023),
    WEEKEND_DISCOUNT(2023),

    BENEFIT_MIN_AMOUNT_CONDITION(10000),
    CHAMPAGNE_PRICE(25000),
    GIVEAWAY_MIN_AMOUNT_CONDITION(120000);

    private final Integer benefitAmount;

    BenefitAmount(Integer benefitAmount) {
        this.benefitAmount = benefitAmount;
    }

    public Integer get() {
        return benefitAmount;
    }
}
