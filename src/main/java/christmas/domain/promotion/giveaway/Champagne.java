package christmas.domain.promotion.giveaway;

import static christmas.constants.Value.CHAMPAGNE_PRICE;
import static christmas.constants.Value.GIVEAWAY_MIN_AMOUNT_CONDITION;
import static christmas.constants.Value.ZERO;

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
            champagne.put(Benefit.GIVEAWAY, calculate(totalAmount));
        }
    }

    private Integer calculate(Integer totalAmount) {
        if (isEligible(totalAmount)) {
            return CHAMPAGNE_PRICE.get();
        }
        return ZERO.get();
    }

    private boolean isEligible(Integer totalAmount) {
        return ((totalAmount / GIVEAWAY_MIN_AMOUNT_CONDITION.get()) > ZERO.get());
    }

    @Override
    public Map<Benefit, Integer> apply() {
        return Collections.unmodifiableMap(champagne);
    }
}
