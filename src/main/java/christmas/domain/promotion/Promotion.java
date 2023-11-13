package christmas.domain.promotion;

import christmas.constants.Benefit;
import java.util.Map;

public interface Promotion {

    Integer calculate();

    boolean isEligible();

    Map<Benefit, Integer> apply();
}
