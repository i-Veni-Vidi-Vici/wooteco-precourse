package christmas.domain.promotion.discount;

import static christmas.constants.Condition.FALSE;
import static christmas.constants.Condition.TRUE;
import static christmas.constants.Value.FIRST_WEEKDAY_DATE;
import static christmas.constants.Value.FIRST_WEEK_LAST_WEEKDAY_DATE;
import static christmas.constants.Value.FIVE_WEEKS;
import static christmas.constants.Value.INITIAL_ZERO;
import static christmas.constants.Value.SEVEN_DAYS;
import static christmas.constants.Value.WEEKDAY_DISCOUNT;
import static christmas.constants.Value.ZERO;

import christmas.constants.Benefit;
import christmas.domain.ReservedMenu;
import christmas.domain.promotion.Promotion;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Weekday implements Promotion {

    private final Map<Benefit, Integer> weekday;

    public Weekday(Integer date, ReservedMenu reservedMenu) {
        weekday = new HashMap<>();

        if (isEligible(date) && (reservedMenu.countDessert() > ZERO.get())) {
            weekday.put(Benefit.WEEKDAY, calculate(date, reservedMenu));
        }
    }

    private Integer calculate(Integer date, ReservedMenu reservedMenu) {
        if (isEligible(date)) {
            return (WEEKDAY_DISCOUNT.get() * reservedMenu.countDessert());
        }

        return ZERO.get();
    }

    private boolean isEligible(Integer date) {
        for (int week = INITIAL_ZERO.get(); week < FIVE_WEEKS.get(); week++) {
            if ((date >= (FIRST_WEEKDAY_DATE.get() + (SEVEN_DAYS.get() * week)))
                    && (date <= (FIRST_WEEK_LAST_WEEKDAY_DATE.get() + (SEVEN_DAYS.get() * week)))) {
                return TRUE.get();
            }
        }

        return FALSE.get();
    }

    @Override
    public Map<Benefit, Integer> apply() {
        return Collections.unmodifiableMap(weekday);
    }
}
