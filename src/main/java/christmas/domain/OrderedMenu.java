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

    public static void checkTotalCount(Map<Food, Integer> orderedMenu) {
        Integer totalCount = 0;

        for (Food food : orderedMenu.keySet()) {
            totalCount += orderedMenu.get(food);
        }
        if (totalCount>20){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
