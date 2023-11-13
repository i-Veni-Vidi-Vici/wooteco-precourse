package christmas.domain.promotion.discount;

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
            return (2023 * reservedMenu.countMain());
        }

        return 0;
    }

    private boolean isEligible(Integer date) {
        for (int i = 0; i < 5; i++) {
            if (date >= ((1 + (7 * i))) && (date <= (2 + (7 * i)))) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Map<Benefit, Integer> apply() {
        return Collections.unmodifiableMap(weekend);
    }
}
