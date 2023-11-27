package christmas.domain.promotion.giveaway;

import christmas.constants.Benefit;
import christmas.domain.promotion.Promotion;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Champagne implements Promotion {
    private final Map<Benefit, Integer> champagne;

    public Champagne(Integer purchaseAmount) {
        champagne = new HashMap<>();

        if (present(purchaseAmount) > 0) {
            champagne.put(Benefit.GIVEAWAY, present(purchaseAmount));
        }
    }

    private Integer present(Integer purchaseAmount) {
        if (purchaseAmount >= 1200000) {
            return 25_000;
        }

        return 0;
    }

    @Override
    public Map<Benefit, Integer> apply() {
        return Collections.unmodifiableMap(champagne);
    }
}
