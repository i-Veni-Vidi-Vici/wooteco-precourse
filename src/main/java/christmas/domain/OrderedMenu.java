package christmas.domain;

import static christmas.constants.Type.APPETIZER;
import static christmas.constants.Type.DESSERT;
import static christmas.constants.Type.DRINK;
import static christmas.constants.Type.MAIN;

import christmas.constants.Food;
import christmas.constants.Type;
import java.util.Map;

public class OrderedMenu {
    Map<Food, Integer> orderedMenu;

    public static void checkFoodCount(Map<Food, Integer> orderedMenu) {

        for (Food food : orderedMenu.keySet()) {
//            if (orderedMenu.get(food) < 1) {
//                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
//            }
        }
    }

    public static Integer checkTotalCount(Map<Food, Integer> orderedMenu) {
        Integer totalCount = 0;

        for (Food food : orderedMenu.keySet()) {
            totalCount += orderedMenu.get(food);
        }
//        if (totalCount > 20) {
//            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
//        }

        return totalCount;
    }

    public static boolean checkOnlyDrink(Map<Food, Integer> orderedMenu) {
        return checkDrink(orderedMenu).equals(checkTotalCount(orderedMenu));

//            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    public static Integer checkAppetizer(Map<Food, Integer> orderedMenu) {
        return checkType(orderedMenu, APPETIZER);
    }

    public static Integer checkMain(Map<Food, Integer> orderedMenu) {
        return checkType(orderedMenu, MAIN);
    }

    public static Integer checkDessert(Map<Food, Integer> orderedMenu) {
        return checkType(orderedMenu, DESSERT);
    }

    public static Integer checkDrink(Map<Food, Integer> orderedMenu) {
        return checkType(orderedMenu, DRINK);
    }

    private static Integer checkType(Map<Food, Integer> orderedMenu, Type type) {
        Integer typeCount = 0;

        for (Food food : orderedMenu.keySet()) {
            if (food.getType() == type) {
                typeCount += orderedMenu.get(food);
            }
        }

        return typeCount;
    }

    public static Integer calculateTotalAmount(Map<Food, Integer> orderedMenu) {
        Integer totalAmount = 0;

        for (Food food : orderedMenu.keySet()) {
            totalAmount += (food.getPrice() * orderedMenu.get(food));
        }

        return totalAmount;
    }

}
