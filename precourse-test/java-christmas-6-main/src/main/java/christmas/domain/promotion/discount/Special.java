package christmas.domain.promotion.discount;

import static christmas.constants.DateValue.FIRST_SPECIAL_DATE;
import static christmas.constants.DateValue.FIVE_WEEKS;
import static christmas.constants.Value.INITIAL_ZERO;
import static christmas.constants.DateValue.SEVEN_DAYS;
import static christmas.constants.DiscountValue.SPECIAL_DISCOUNT;
import static christmas.constants.Value.ZERO;

import christmas.constants.Benefit;
import christmas.constants.DateValue;
import christmas.domain.promotion.Promotion;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Special implements Promotion {
    private final Map<Benefit, Integer> special;

    public Special(Integer date) {
        special = new HashMap<>();

        if (discount(date) > ZERO.get()) {
            special.put(Benefit.SPECIAL, discount(date));
        }
    }

    private Integer discount(Integer date) {
        for (int week = INITIAL_ZERO.get(); week < FIVE_WEEKS.get(); week++) {
            if ((date == (FIRST_SPECIAL_DATE.get() + (SEVEN_DAYS.get() * week)))
                    || (date.equals(DateValue.XMAS_DATE.get()))) {
                return SPECIAL_DISCOUNT.get();
            }
        }

        return ZERO.get();
    }

    @Override
    public Map<Benefit, Integer> apply() {
        return Collections.unmodifiableMap(special);
    }
}
