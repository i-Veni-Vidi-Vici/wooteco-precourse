package christmas.domain.promotion.discount;

import christmas.constants.Benefit;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Xmas {
    private final Map<Benefit, Integer> xmas;

    public Xmas(Integer date) {
        xmas = new HashMap<>();

        if (checkXmasPeriod(date)) {
            xmas.put(Benefit.SPECIAL, calculateXmas(date));
        }
    }

    public static Integer calculateXmas(Integer date) {
        if (checkXmasPeriod(date)) {
            return (1000 + ((date - 1) * 100));
        }

        return 0;
    }

    public static boolean checkXmasPeriod(Integer date) {
        return (date <= 25);
    }

    public Map<Benefit, Integer> apply() {
        return Collections.unmodifiableMap(xmas);
    }
}
