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

        if (discount(date) > 0) {
            xmas.put(Benefit.XMAS, discount(date));
        }
    }

    private Integer discount(Integer date) {
        if (date <= 25) {
            return (1000 + ((date - 1) * 100));
        }

        return 0;
    }

    @Override
    public Map<Benefit, Integer> apply() {
        return Collections.unmodifiableMap(xmas);
    }
}
