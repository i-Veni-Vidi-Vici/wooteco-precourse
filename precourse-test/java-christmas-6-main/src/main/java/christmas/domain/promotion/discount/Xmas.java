package christmas.domain.promotion.discount;

import static christmas.constants.DiscountValue.FIRST_XMAS_DISCOUNT;
import static christmas.constants.DateValue.ONE_DAY;
import static christmas.constants.DateValue.XMAS_DATE;
import static christmas.constants.DiscountValue.XMAS_INCREASE_DISCOUNT;
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

        if (discount(date) > ZERO.get()) {
            xmas.put(Benefit.XMAS, discount(date));
        }
    }

    private Integer discount(Integer date) {
        if (date <= XMAS_DATE.get()) {
            return (FIRST_XMAS_DISCOUNT.get() + ((date - ONE_DAY.get()) * XMAS_INCREASE_DISCOUNT.get()));
        }

        return ZERO.get();
    }

    @Override
    public Map<Benefit, Integer> apply() {
        return Collections.unmodifiableMap(xmas);
    }
}
