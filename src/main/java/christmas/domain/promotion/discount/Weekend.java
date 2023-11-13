package christmas.domain.promotion.discount;

import christmas.constants.Benefit;
import christmas.domain.ReservedMenu;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Weekend {
    private final Map<Benefit, Integer> weekend;

    public Weekend(Integer date, ReservedMenu reservedMenu) {
        weekend = new HashMap<>();

        if (checkWeekend(date)) {
            weekend.put(Benefit.SPECIAL, calculateWeekend(date, reservedMenu));
        }
    }
    public Integer calculateWeekend(Integer day, ReservedMenu reservedMenu) {
        if (checkWeekend(day)) {
            return (2023 * reservedMenu.countMain());
        }

        return 0;
    }

    public boolean checkWeekend(Integer day) {
        for (int i = 0; i < 5; i++) {
            if (day >= ((1 + (7 * i))) && (day <= (2 + (7 * i)))) {
                return true;
            }
        }

        return false;
    }

    public Map<Benefit, Integer> apply() {
        return Collections.unmodifiableMap(weekend);
    }
}
