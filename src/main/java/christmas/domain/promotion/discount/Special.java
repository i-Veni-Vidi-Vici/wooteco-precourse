package christmas.domain.promotion.discount;

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
            return 1000;
        }

        return 0;
    }

    @Override
    private boolean isEligible(Integer date) {
        for (int i = 0; i < 5; i++) {
            if (date == ((3 + (7 * i))) || (date == 25)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Map<Benefit, Integer> apply() {
        return Collections.unmodifiableMap(special);
    }
}
