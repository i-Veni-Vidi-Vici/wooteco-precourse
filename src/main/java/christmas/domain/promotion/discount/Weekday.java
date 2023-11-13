package christmas.domain.promotion.discount;

import christmas.constants.Benefit;
import christmas.domain.ReservedMenu;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Weekday {

    private final Map<Benefit, Integer> weekday;

    public Weekday(Integer date, ReservedMenu reservedMenu) {
        weekday = new HashMap<>();

        if (checkWeekday(date)) {
            weekday.put(Benefit.SPECIAL, calculateWeekday(date, reservedMenu));
        }
    }

    public Integer calculateWeekday(Integer date, ReservedMenu reservedMenu) {
        if (checkWeekday(date)) {
            return (2023 * reservedMenu.countDessert());
        }

        return 0;
    }

    public boolean checkWeekday(Integer date) {
        for (int i = 0; i < 5; i++) {
            if (date >= ((3 + (7 * i))) && (date <= (7 + (7 * i)))) {
                return true;
            }
        }

        return false;
    }

    public Map<Benefit, Integer> apply() {
        return Collections.unmodifiableMap(weekday);
    }
}
