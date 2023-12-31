package christmas.domain;

import static christmas.constants.Type.DESSERT;
import static christmas.constants.Type.DRINK;
import static christmas.constants.Type.MAIN;
import static christmas.constants.Value.INITIAL_ZERO;
import static christmas.constants.Value.MAX_TOTAL_FOOD_COUNT;
import static christmas.constants.Value.MIN_FOOD_COUNT;

import christmas.constants.Food;
import christmas.constants.Type;
import java.util.Collections;
import java.util.Map;

public class ReservedMenu {

    private final Map<Food, Integer> reservedMenu;

    public ReservedMenu(Map<Food, Integer> reservedMenu) {
        checkFoodCount(reservedMenu);
        checkOnlyDrink(reservedMenu);
        checkTotalFoodCount(reservedMenu);
        this.reservedMenu = Collections.unmodifiableMap(reservedMenu);
    }

    private void checkFoodCount(Map<Food, Integer> reservedMenu) {
        for (Food food : reservedMenu.keySet()) {
            if (reservedMenu.get(food) < MIN_FOOD_COUNT.get()) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkOnlyDrink(Map<Food, Integer> reservedMenu) {
        if (countDrink(reservedMenu).equals(checkTotalFoodCount(reservedMenu))) {
            throw new IllegalArgumentException();
        }
    }

    private Integer checkTotalFoodCount(Map<Food, Integer> reservedMenu) {
        Integer totalCount = INITIAL_ZERO.get();

        for (Food food : reservedMenu.keySet()) {
            totalCount += reservedMenu.get(food);
        }

        if (totalCount > MAX_TOTAL_FOOD_COUNT.get()) {
            throw new IllegalArgumentException();
        }

        return totalCount;
    }

    public Integer countMain() {
        return checkType(reservedMenu, MAIN);
    }

    public Integer countDessert() {
        return checkType(reservedMenu, DESSERT);
    }

    private Integer countDrink(Map<Food, Integer> reservedMenu) {
        return checkType(reservedMenu, DRINK);
    }

    private Integer checkType(Map<Food, Integer> reservedMenu, Type type) {
        Integer typeCount = INITIAL_ZERO.get();

        for (Food food : reservedMenu.keySet()) {
            if (food.getType() == type) {
                typeCount += reservedMenu.get(food);
            }
        }

        return typeCount;
    }

    public Integer calculateTotalAmount() {
        Integer totalAmount = INITIAL_ZERO.get();

        for (Food food : reservedMenu.keySet()) {
            totalAmount += (food.getPrice() * reservedMenu.get(food));
        }

        return totalAmount;
    }

    public Map<Food, Integer> getMenu() {
        return reservedMenu;
    }
}
