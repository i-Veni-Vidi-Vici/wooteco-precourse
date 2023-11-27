package christmas.domain.promotion.giveaway;

import static christmas.constants.DiscountValue.MIN_AMOUNT_OF_GIVEAWAY_CONDITION;
import static christmas.constants.Value.ZERO;

import christmas.constants.Benefit;
import christmas.constants.Food;
import christmas.domain.promotion.Promotion;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Champagne implements Promotion {
    private final Map<Benefit, Integer> champagne;

    public Champagne(Integer purchaseAmount) {
        champagne = new HashMap<>();

        if (present(purchaseAmount) > ZERO.get()) {
            champagne.put(Benefit.GIVEAWAY, present(purchaseAmount));
        }
    }

    private Integer present(Integer purchaseAmount) {
        if (purchaseAmount >= MIN_AMOUNT_OF_GIVEAWAY_CONDITION.get()) {
            return Food.CHAMPAGNE.getPrice();
        }

        return ZERO.get();
    }

    @Override
    public Map<Benefit, Integer> apply() {
        return Collections.unmodifiableMap(champagne);
    }
}
