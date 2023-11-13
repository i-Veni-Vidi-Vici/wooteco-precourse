package christmas.domain.promotion;

import christmas.constants.Benefit;
import java.util.Map;

public interface Promotion {

    boolean isEligible(Integer value);

    Map<Benefit, Integer> apply();
}
