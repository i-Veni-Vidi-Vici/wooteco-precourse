package christmas.domain.promotion.discount;

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

        if (isEligible(date)) {
            weekday.put(Benefit.WEEKDAY, calculate(date, reservedMenu));
        }
    }

    public Integer calculate(Integer date, ReservedMenu reservedMenu) {
        if (isEligible(date)) {
            return (2023 * reservedMenu.countDessert());
        }

        return 0;
    }

    @Override
    public boolean isEligible(Integer date) {
        for (int i = 0; i < 5; i++) {
            if (date >= ((3 + (7 * i))) && (date <= (7 + (7 * i)))) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Map<Benefit, Integer> apply() {
        return Collections.unmodifiableMap(weekday);
    }
}
