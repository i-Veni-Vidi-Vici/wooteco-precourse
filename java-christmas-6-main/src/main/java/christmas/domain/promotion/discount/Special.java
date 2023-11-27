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

        if (discount(date) > 0) {
            special.put(Benefit.SPECIAL, discount(date));
        }
    }

    private Integer discount(Integer date) {
        for (int week = 0; week < 5; week++) {
            if ((date == (3 + (7 * week))) || (date == 25)) {
                return 1000;
            }
        }

        return 0;
    }

    @Override
    public Map<Benefit, Integer> apply() {
        return Collections.unmodifiableMap(special);
    }
}
