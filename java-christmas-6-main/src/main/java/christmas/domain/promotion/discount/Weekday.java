package christmas.domain.promotion.discount;

import christmas.constants.Benefit;
import christmas.domain.promotion.Promotion;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Weekday implements Promotion {

    private final Map<Benefit, Integer> weekday;

    public Weekday(Integer date, Integer dessertCount) {
        weekday = new HashMap<>();

        if (discount(date,dessertCount) > 0) {
            weekday.put(Benefit.WEEKDAY, discount(date,dessertCount));
        }
    }

    private Integer discount(Integer date, Integer dessertCount) {
        for (int week = 0; week < 5; week++) {
            if ((date >= (3 + (7 * week))) && (date <= (7 + (7 * week))) && (date <= 31)) {
                return (dessertCount * 2023);
            }
        }

        return 0;
    }

    @Override
    public Map<Benefit, Integer> apply() {
        return Collections.unmodifiableMap(weekday);
    }
}
