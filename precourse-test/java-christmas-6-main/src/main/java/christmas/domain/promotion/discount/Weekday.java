package christmas.domain.promotion.discount;

import static christmas.constants.DateValue.FIRST_WEEKDAY_DATE;
import static christmas.constants.DateValue.FIRST_WEEK_LAST_WEEKDAY_DATE;
import static christmas.constants.DateValue.FIVE_WEEKS;
import static christmas.constants.Value.INITIAL_ZERO;
import static christmas.constants.DateValue.MAX_DATE;
import static christmas.constants.DateValue.SEVEN_DAYS;
import static christmas.constants.DiscountValue.WEEKDAY_DISCOUNT;
import static christmas.constants.Value.ZERO;

import christmas.constants.Benefit;
import christmas.domain.promotion.Promotion;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Weekday implements Promotion {
    private final Map<Benefit, Integer> weekday;

    public Weekday(Integer date, Integer dessertCount) {
        weekday = new HashMap<>();

        if (discount(date,dessertCount) > ZERO.get()) {
            weekday.put(Benefit.WEEKDAY, discount(date,dessertCount));
        }
    }

    private Integer discount(Integer date, Integer dessertCount) {
        for (int week = INITIAL_ZERO.get(); week < FIVE_WEEKS.get(); week++) {
            if ((date >= (FIRST_WEEKDAY_DATE.get() + (SEVEN_DAYS.get() * week))) &&
                    (date <= (FIRST_WEEK_LAST_WEEKDAY_DATE.get() + (SEVEN_DAYS.get() * week))) && (date <= MAX_DATE.get())) {
                return (dessertCount * WEEKDAY_DISCOUNT.get());
            }
        }

        return ZERO.get();
    }

    @Override
    public Map<Benefit, Integer> apply() {
        return Collections.unmodifiableMap(weekday);
    }
}
