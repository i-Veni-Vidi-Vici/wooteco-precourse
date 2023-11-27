package christmas.domain.promotion.discount;

import static christmas.constants.DateValue.FIRST_WEEKEND_DATE;
import static christmas.constants.DateValue.FIRST_WEEK_LSAT_WEEKEND_DATE;
import static christmas.constants.DateValue.FIVE_WEEKS;
import static christmas.constants.Value.INITIAL_ZERO;
import static christmas.constants.DateValue.SEVEN_DAYS;
import static christmas.constants.DiscountValue.WEEKEND_DISCOUNT;
import static christmas.constants.Value.ZERO;

import christmas.constants.Benefit;
import christmas.domain.promotion.Promotion;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Weekend implements Promotion {

    private final Map<Benefit, Integer> weekend;

    public Weekend(Integer date, Integer mainCount) {
        weekend = new HashMap<>();

        if (discount(date, mainCount) > ZERO.get()) {
            weekend.put(Benefit.WEEKEND, discount(date, mainCount));
        }
    }

    private Integer discount(Integer date, Integer mainCount) {
        for (int week = INITIAL_ZERO.get(); week < FIVE_WEEKS.get(); week++) {
            if ((date == (FIRST_WEEKEND_DATE.get() + (SEVEN_DAYS.get() * week)))
                    || (date == (FIRST_WEEK_LSAT_WEEKEND_DATE.get() + (SEVEN_DAYS.get() * week)))) {
                return (mainCount * WEEKEND_DISCOUNT.get());
            }
        }

        return ZERO.get();
    }

    @Override
    public Map<Benefit, Integer> apply() {
        return Collections.unmodifiableMap(weekend);
    }
}
