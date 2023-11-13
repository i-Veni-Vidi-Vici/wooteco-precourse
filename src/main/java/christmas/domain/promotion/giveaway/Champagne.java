package christmas.domain.promotion.giveaway;

import christmas.constants.Benefit;
import christmas.domain.promotion.Promotion;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Champagne implements Promotion {

    private final Map<Benefit, Integer> champagne;

    public Champagne(Integer totalAmount) {
        champagne = new HashMap<>();

        if (isEligible(totalAmount)) {
            champagne.put(Benefit.SPECIAL, calculate(totalAmount));
        }
    }

    public Integer calculate(Integer totalAmount) {
        if (isEligible(totalAmount)) {
            return 25000;
        }
        return 0;
    }

    @Override
    public boolean isEligible(Integer totalAmount) {
        return ((totalAmount / 120000) > 0);
    }

    @Override
    public Map<Benefit, Integer> apply() {
        return Collections.unmodifiableMap(champagne);
    }
}
