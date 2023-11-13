package christmas.domain.promotion.discount;

import christmas.constants.Benefit;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Special {

    private final Map<Benefit, Integer> special;

    public Special(Integer date) {
        special = new HashMap<>();

        if (checkSpecial(date)) {
            special.put(Benefit.SPECIAL, calculateSpecial(date));
        }
    }

    public Integer calculateSpecial(Integer date) {
        if (checkSpecial(date)) {
            return 1000;
        }

        return 0;
    }

    public boolean checkSpecial(Integer date) {
        for (int i = 0; i < 5; i++) {
            if (date == ((3 + (7 * i))) || (date == 25)) {
                return true;
            }
        }

        return false;
    }

    public Map<Benefit, Integer> apply() {
        return Collections.unmodifiableMap(special);
    }
}
