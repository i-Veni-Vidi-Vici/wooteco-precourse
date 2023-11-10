package christmas.domain;

import static christmas.constants.Type.APPETIZER;
import static christmas.constants.Type.DESSERT;
import static christmas.constants.Type.DRINK;
import static christmas.constants.Type.MAIN;

import christmas.constants.Food;
import christmas.constants.Type;
import java.util.Map;

public class Order {

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

        return  totalAmount;
    }

}
