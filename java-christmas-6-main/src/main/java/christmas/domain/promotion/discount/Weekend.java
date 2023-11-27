package christmas.domain.promotion.discount;

import christmas.constants.Benefit;
import christmas.domain.promotion.Promotion;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Weekend implements Promotion {

    private final Map<Benefit, Integer> weekend;

    public Weekend(Integer date, Integer mainCount) {
        weekend = new HashMap<>();

        if (discount(date,mainCount) > 0) {
            weekend.put(Benefit.WEEKEND, discount(date,mainCount));
        }
    }

    private Integer discount(Integer date, Integer mainCount) {
        for (int week = 0; week < 5; week++) {
            if ((date == (1 + (7 * week))) || (date == (2 + (7 * week)))) {
                return (mainCount * 2023);
            }
        }

        return 0;
    }

    @Override
    public Map<Benefit, Integer> apply() {
        return Collections.unmodifiableMap(weekend);
    }
}
