package christmas.domain;

import christmas.constants.Food;
import java.util.Map;

public class OrderedMenu {


    public static void checkFoodCount(Map<Food, Integer> orderedMenu) {

        for (Food food : orderedMenu.keySet()) {
            if (orderedMenu.get(food) < 1) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }
}
