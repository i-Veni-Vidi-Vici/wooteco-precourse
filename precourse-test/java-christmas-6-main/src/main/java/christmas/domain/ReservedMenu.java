package christmas.domain;

import static christmas.constants.Value.INITIAL_ZERO;
import static christmas.constants.Value.MAX_TOTAL_COUNT;
import static christmas.constants.Value.MIN_MENU_COUNT;

import christmas.constants.Food;
import christmas.constants.Type;
import java.util.Collections;
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
        if (countMenu(reservedMenu) > MAX_TOTAL_COUNT.get()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkMenuCount(Map<Food, Integer> reservedMenu) {
        for (Food food : reservedMenu.keySet()) {
            if (reservedMenu.get(food) < MIN_MENU_COUNT.get()) {
                throw new IllegalArgumentException();
            }
        }
    }

    public Integer calculateAmount() {
        Integer sum = INITIAL_ZERO.get();

        for (Food food : reservedMenu.keySet()) {
            sum += (reservedMenu.get(food) * food.getPrice());
        }

        return sum;
    }

    public Integer countDessert() {
        return count(Type.DESSERT);
    }

    public Integer countMain() {
        return count(Type.MAIN);
    }

    private Integer count(Type type) {
        Integer count = INITIAL_ZERO.get();

        for (Food food : reservedMenu.keySet()) {
            if (food.getType() == type) {
                count += reservedMenu.get(food);
            }
        }

        return count;
    }

    private Integer countDrink(Map<Food, Integer> reservedMenu) {
        Integer drinkCount = INITIAL_ZERO.get();

        for (Food food : reservedMenu.keySet()) {
            if (food.getType() == Type.DRINK) {
                drinkCount += reservedMenu.get(food);
            }
        }

        return drinkCount;
    }

    private Integer countMenu(Map<Food, Integer> reservedMenu) {
        Integer menuCount = INITIAL_ZERO.get();

        for (Food food : reservedMenu.keySet()) {
            menuCount += reservedMenu.get(food);
        }

        return menuCount;
    }

    public Map<Food, Integer> get() {
        return Collections.unmodifiableMap(reservedMenu);
    }
}
