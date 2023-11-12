package christmas.domain;

import static christmas.constants.Type.DESSERT;
import static christmas.constants.Type.DRINK;
import static christmas.constants.Type.MAIN;

import christmas.constants.Food;
import christmas.constants.Type;
import java.util.Map;

public class ReservedMenu {
    private final Map<Food, Integer> reservedMenu;

    public ReservedMenu(Map<Food, Integer> reservedMenu) {
        checkFoodCount(reservedMenu);
        checkOnlyDrink(reservedMenu);
        checkTotalFoodCount(reservedMenu);
        this.reservedMenu = reservedMenu;
    }

    private void checkFoodCount(Map<Food, Integer> reservedMenu) {
        for (Food food : reservedMenu.keySet()) {
            if (reservedMenu.get(food) < 1) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    private void checkOnlyDrink(Map<Food, Integer> reservedMenu) {
        if (countDrink(reservedMenu).equals(checkTotalFoodCount(reservedMenu))) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private Integer checkTotalFoodCount(Map<Food, Integer> reservedMenu) {
        Integer totalCount = 0;

        for (Food food : reservedMenu.keySet()) {
            totalCount += reservedMenu.get(food);
        }
        if (totalCount > 20) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
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
        Integer typeCount = 0;

        for (Food food : reservedMenu.keySet()) {
            if (food.getType() == type) {
                typeCount += reservedMenu.get(food);
            }
        }

        return typeCount;
    }

    public Integer calculateTotalAmount() {
        Integer totalAmount = 0;

        for (Food food : reservedMenu.keySet()) {
            totalAmount += (food.getPrice() * reservedMenu.get(food));
        }

        return totalAmount;
    }

}
