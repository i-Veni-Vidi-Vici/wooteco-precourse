package christmas.domain;

import christmas.constants.Food;
import java.util.Map;

public class Order {

    public static Integer checkAppetizer(Map<Food, Integer> orderedMenu) {
        return checkType(orderedMenu, "애피타이저");
    }

    public static Integer checkMain(Map<Food, Integer> orderedMenu) {
        return checkType(orderedMenu, "메인");
    }

    public static Integer checkDessert(Map<Food, Integer> orderedMenu) {
        return checkType(orderedMenu, "디저트");
    }

    public static Integer checkDrink(Map<Food, Integer> orderedMenu) {
        return checkType(orderedMenu, "음료");
    }

    private static Integer checkType(Map<Food, Integer> orderedMenu, String type) {
        Integer typeCount = 0;

        for (Food food : orderedMenu.keySet()) {
            if (food.getType().equals(type)) {
                typeCount += orderedMenu.get(food);
            }
        }

        return typeCount;
    }
}
