package christmas.domain.promotion.discount;

import static christmas.constants.BenefitAmount.FIRST_XMAS_DISCOUNT;
import static christmas.constants.DateValue.ONE_DATE;
import static christmas.constants.DateValue.XMAS_DATE;
import static christmas.constants.BenefitAmount.XMAS_INCREMENT_DISCOUNT;
import static christmas.constants.Value.ZERO;

import christmas.constants.Benefit;
import christmas.domain.promotion.Promotion;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Xmas implements Promotion {
    private final Map<Benefit, Integer> xmas;

    public Xmas(Integer date) {
        xmas = new HashMap<>();

        if (isEligible(date)) {
            xmas.put(Benefit.CHRISTMAS, calculate(date));
        }
    }

    private Integer calculate(Integer date) {
        if (isEligible(date)) {
            return (FIRST_XMAS_DISCOUNT.get() + ((date - ONE_DATE.get()) * XMAS_INCREMENT_DISCOUNT.get()));
        }

        return ZERO.get();
    }

    private boolean isEligible(Integer date) {
        return (date <= XMAS_DATE.get());
    }

    @Override
    public Map<Benefit, Integer> apply() {
        return Collections.unmodifiableMap(xmas);
    }
}
