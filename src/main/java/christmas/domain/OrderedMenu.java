package christmas.domain;

import static christmas.constants.Type.DESSERT;
import static christmas.constants.Type.DRINK;
import static christmas.constants.Type.MAIN;

import christmas.constants.Food;
import christmas.constants.Type;
import java.util.Map;

public class OrderedMenu {
    private final Map<Food, Integer> orderedMenu;

    public OrderedMenu(Map<Food, Integer> orderedMenu) {
        checkFoodCount(orderedMenu);
        checkOnlyDrink(orderedMenu);
        checkTotalFoodCount(orderedMenu);
        this.orderedMenu = orderedMenu;
    }

    private void checkFoodCount(Map<Food, Integer> orderedMenu) {
        for (Food food : orderedMenu.keySet()) {
            if (orderedMenu.get(food) < 1) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    private void checkOnlyDrink(Map<Food, Integer> orderedMenu) {
        if (countDrink(orderedMenu).equals(checkTotalFoodCount(orderedMenu))) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private Integer checkTotalFoodCount(Map<Food, Integer> orderedMenu) {
        Integer totalCount = 0;

        for (Food food : orderedMenu.keySet()) {
            totalCount += orderedMenu.get(food);
        }
        if (totalCount > 20) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

        return totalCount;
    }

    public Integer countMain() {
        return checkType(orderedMenu, MAIN);
    }

    public Integer countDessert() {
        return checkType(orderedMenu, DESSERT);
    }

    private Integer countDrink(Map<Food, Integer> orderedMenu) {
        return checkType(orderedMenu, DRINK);
    }

    private Integer checkType(Map<Food, Integer> orderedMenu, Type type) {
        Integer typeCount = 0;

        for (Food food : orderedMenu.keySet()) {
            if (food.getType() == type) {
                typeCount += orderedMenu.get(food);
            }
        }

        return typeCount;
    }

    public Integer countTotalFood() {
        Integer totalCount = 0;

        for (Food food : orderedMenu.keySet()) {
            totalCount += orderedMenu.get(food);
        }

        return totalCount;
    }

    public Integer calculateTotalAmount() {
        Integer totalAmount = 0;

        for (Food food : orderedMenu.keySet()) {
            totalAmount += (food.getPrice() * orderedMenu.get(food));
        }

        return totalAmount;
    }

}
