package christmas.domain;

import christmas.constants.Food;
import christmas.constants.Type;
import java.util.Map;

public class ReservedMenu {

    private final Map<Food, Integer> reservedMenu;

    public ReservedMenu(Map<Food, Integer> reservedMenu) {
        checkOnlyDrink(reservedMenu);
        checkTotalCount(reservedMenu);
        checkMenuCount(reservedMenu);

        this.reservedMenu = reservedMenu;
    }

    private void checkOnlyDrink(Map<Food, Integer> reservedMenu) {
        if (countDrink(reservedMenu).equals(countMenu(reservedMenu))) {
            throw new IllegalArgumentException();
        }
    }

    private void checkTotalCount(Map<Food, Integer> reservedMenu) {
        if (countMenu(reservedMenu) > 20) {
            throw new IllegalArgumentException();
        }
    }

    private void checkMenuCount(Map<Food, Integer> reservedMenu) {
        for (Food food : reservedMenu.keySet()) {
            if (reservedMenu.get(food) < 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    public Integer calculateAmount() {
        Integer sum = 0;

        for (Food food : reservedMenu.keySet()) {
            sum += (reservedMenu.get(food) * food.getPrice());
        }

        return sum;
    }

    public Integer countDessert() {
        Integer dessertCount = 0;

        for (Food food : reservedMenu.keySet()) {
            if (food.getType() == Type.DESSERT) {
                dessertCount += reservedMenu.get(food);
            }
        }

        return dessertCount;
    }

    public Integer countMain() {
        Integer mainCount = 0;

        for (Food food : reservedMenu.keySet()) {
            if (food.getType() == Type.MAIN) {
                mainCount += reservedMenu.get(food);
            }
        }

        return mainCount;
    }

    private Integer countDrink(Map<Food, Integer> reservedMenu) {
        Integer drinkCount = 0;

        for (Food food : reservedMenu.keySet()) {
            if (food.getType() == Type.DRINK) {
                drinkCount += reservedMenu.get(food);
            }
        }

        return drinkCount;
    }

    private Integer countMenu(Map<Food, Integer> reservedMenu) {
        Integer menuCount = 0;

        for (Food food : reservedMenu.keySet()) {
            menuCount += reservedMenu.get(food);
        }

        return menuCount;
    }
}
