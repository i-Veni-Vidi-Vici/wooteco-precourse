package christmas.domain;

import static christmas.constants.Type.APPETIZER;
import static christmas.constants.Type.DESSERT;
import static christmas.constants.Type.DRINK;
import static christmas.constants.Type.MAIN;

import christmas.constants.Food;
import christmas.constants.Type;
import christmas.utility.Converter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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

    private static List<String> convertToList(String userInput) {
        return Arrays.asList(userInput.split(","));
    }

    public static Map<String, Integer> convertToMap(String userInput) {
        Map<String, Integer> menu = new HashMap<>();
        List<String> inputs = convertToList(userInput);

        for (String input : inputs) {
            String[] separatedInput = input.split("-");
            checkMenu(separatedInput[0]);
            menu.put(separatedInput[0], Converter.convertToNumber(separatedInput[1],
                    "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."));
        }

        checkDuplication(inputs, menu);
        return menu;
    }

    public static void checkMenu(String userInput) {
        for (Food food : Food.values()) {
            if (food.getName().equals(userInput)) {
                return;
            }
        }

        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    private static void checkDuplication(List<String> inputs, Map<String,Integer> menu) {
        if(inputs.size() != menu.size()){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
