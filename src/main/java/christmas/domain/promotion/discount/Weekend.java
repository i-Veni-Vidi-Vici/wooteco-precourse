package christmas.domain.promotion.discount;

import static christmas.constants.Condition.FALSE;
import static christmas.constants.Condition.TRUE;
import static christmas.constants.Value.FIRST_WEEKEND_DATE;
import static christmas.constants.Value.FIRST_WEEK_LAST_WEEKEND_DATE;
import static christmas.constants.Value.FIVE_WEEKS;
import static christmas.constants.Value.INITIAL_ZERO;
import static christmas.constants.Value.SEVEN_DAYS;
import static christmas.constants.Value.WEEKEND_DISCOUNT;
import static christmas.constants.Value.ZERO;

import christmas.constants.Benefit;
import christmas.domain.ReservedMenu;
import christmas.domain.promotion.Promotion;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Weekend implements Promotion {
    private final Map<Benefit, Integer> weekend;

    public Weekend(Integer date, ReservedMenu reservedMenu) {
        weekend = new HashMap<>();

        if (isEligible(date)) {
            weekend.put(Benefit.WEEKEND, calculate(date, reservedMenu));
        }
    }

    private Integer calculate(Integer date, ReservedMenu reservedMenu) {
        if (isEligible(date)) {
            return (WEEKEND_DISCOUNT.get() * reservedMenu.countMain());
        }

        return ZERO.get();
    }

    private boolean isEligible(Integer date) {
        for (int week = INITIAL_ZERO.get(); week < FIVE_WEEKS.get(); week++) {
            if ((date >= (FIRST_WEEKEND_DATE.get() + (SEVEN_DAYS.get() * week)))
                    && (date <= (FIRST_WEEK_LAST_WEEKEND_DATE.get() + (SEVEN_DAYS.get() * week)))) {
                return TRUE.get();
            }
        }

        return FALSE.get();
    }

    @Override
    public Map<Benefit, Integer> apply() {
        return Collections.unmodifiableMap(weekend);
    }
}
