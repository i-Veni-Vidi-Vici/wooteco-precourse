package christmas.domain.promotion;

import christmas.constants.Benefit;
import java.util.Map;

public interface Promotion {
    Map<Benefit, Integer> apply();
}
