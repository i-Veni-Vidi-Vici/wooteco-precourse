package christmas.domain;

import christmas.constants.Food;
import java.util.Map;

public class Order {

    public static Integer checkAppetizer(Map<Food, Integer> orderedMenu) {
        Integer appetizerCount = 0;

        for (Food food : orderedMenu.keySet()) {
            if (food.getType().equals("애피타이저")) {
                appetizerCount += orderedMenu.get(food);
            }
        }

        return appetizerCount;
    }
}
