package christmas.domain.promotion.discount;

import christmas.constants.Benefit;
import christmas.domain.promotion.Promotion;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Xmas implements Promotion {
    private final Map<Benefit, Integer> xmas;

    public Xmas(Integer date) {
        xmas = new HashMap<>();

        if (isEligible(date)) {
            xmas.put(Benefit.CHRISTMAS, calculate(date));
        }
    }

    public Integer calculate(Integer date) {
        if (isEligible(date)) {
            return (1000 + ((date - 1) * 100));
        }

        return 0;
    }

    @Override
    public boolean isEligible(Integer date) {
        return (date <= 25);
    }


    @Override
    public Map<Benefit, Integer> apply() {
        return Collections.unmodifiableMap(xmas);
    }
}
