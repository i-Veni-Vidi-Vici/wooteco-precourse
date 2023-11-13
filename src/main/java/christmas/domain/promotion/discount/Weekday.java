package christmas.domain.promotion.discount;

import christmas.constants.Benefit;
import christmas.domain.ReservedMenu;
import java.util.HashMap;
import java.util.Map;

public class Weekday {

    private final Map<Benefit, Integer> weekday;

    public Weekday(Integer date) {
        weekday = new HashMap<>();

        if (checkWeekday(date)) {
            weekday.put(Benefit.SPECIAL, calculateSpecial(date));
        }
    }

    public Integer calculateWeekday(Integer day, ReservedMenu reservedMenu) {
        if (checkWeekday(day)) {
            return (2023 * reservedMenu.countDessert());
        }

        return 0;
    }

    public boolean checkWeekday(Integer day) {
        for (int i = 0; i < 5; i++) {
            if (day >= ((3 + (7 * i))) && (day <= (7 + (7 * i)))) {
                return true;
            }
        }

        return false;
    }
}
