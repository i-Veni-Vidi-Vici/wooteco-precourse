package christmas.domain;

import christmas.constants.Food;
import christmas.constants.Type;
import java.util.Collections;
import java.util.Map;

public class ReservedMenu {

    private final Map<Food, Integer> reservedMenu;

    public ReservedMenu(Map<Food, Integer> reservedMenu) {
        this.reservedMenu = reservedMenu;
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
                dessertCount++;
            }
        }

        return dessertCount;
    }

    public Integer countMain() {
        Integer mainCount = 0;

        for (Food food : reservedMenu.keySet()) {
            if (food.getType() == Type.MAIN) {
                mainCount++;
            }
        }

        return mainCount;
    }


    public Map<Food, Integer> get() {
        return Collections.unmodifiableMap(reservedMenu);
    }
}
