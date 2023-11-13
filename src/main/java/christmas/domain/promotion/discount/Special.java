package christmas.domain.promotion.discount;

import static christmas.constants.Condition.FALSE;
import static christmas.constants.Condition.TRUE;
import static christmas.constants.Value.FIRST_SPECIAL_DATE;
import static christmas.constants.Value.FIVE_WEEKS;
import static christmas.constants.Value.INITIAL_ZERO;
import static christmas.constants.Value.SEVEN_DAYS;
import static christmas.constants.Value.SPECIAL_DISCOUNT;
import static christmas.constants.Value.XMAS_DATE;
import static christmas.constants.Value.ZERO;

import christmas.constants.Benefit;
import christmas.domain.promotion.Promotion;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Special implements Promotion {

    private final Map<Benefit, Integer> special;

    public Special(Integer date) {
        special = new HashMap<>();

        if (isEligible(date)) {
            special.put(Benefit.SPECIAL, calculate(date));
        }
    }

    private Integer calculate(Integer date) {
        if (isEligible(date)) {
            return SPECIAL_DISCOUNT.get();
        }

        return ZERO.get();
    }

    private boolean isEligible(Integer date) {
        for (int week = INITIAL_ZERO.get(); week < FIVE_WEEKS.get(); week++) {
            if ((date.equals(FIRST_SPECIAL_DATE.get() + (SEVEN_DAYS.get() * week)))
                    || (date.equals(XMAS_DATE.get()))) {
                return TRUE.get();
            }
        }

        return FALSE.get();
    }

    @Override
    public Map<Benefit, Integer> apply() {
        return Collections.unmodifiableMap(special);
    }
}
