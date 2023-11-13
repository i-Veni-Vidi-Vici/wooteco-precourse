package christmas.domain.promotion.giveaway;

import christmas.constants.Benefit;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Champagne {

    private final Map<Benefit, Integer> champagne;

    public Champagne(Integer date) {
        champagne = new HashMap<>();

        if (checkChampagne(date)) {
            champagne.put(Benefit.SPECIAL, calculateChampagne(date));
        }
    }

    public boolean checkChampagne(Integer totalAmount) {
        return ((totalAmount / 120000) > 0);
    }

    public Integer calculateChampagne(Integer totalAmount) {
        if (checkChampagne(totalAmount)) {
            return 25000;
        }
        return 0;
    }

    public Map<Benefit, Integer> apply() {
        return Collections.unmodifiableMap(champagne);
    }
}
