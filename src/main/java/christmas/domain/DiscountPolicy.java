package christmas.domain;

import christmas.constants.Food;
import java.util.Map;

public class DiscountPolicy {

    public static Integer calculateChristmas(Integer day) {
        if (checkChristmasPeriod(day)) {
            return (1000 + ((day - 1) * 100));
        }

        return 0;
    }

    public static boolean checkTarget(Integer totalAmount) {
        return (totalAmount >= 10000);
    }

    private static boolean checkChristmasPeriod(Integer day) {
        return (day <= 25);
    }

    public static Integer calculateWeekday(Integer day, Map<Food, Integer> orderedMenu) {
        if (checkWeekday(day)) {
            return (2023 * Order.checkDessert(orderedMenu));
        }

        return 0;
    }

    private static boolean checkWeekday(Integer day) {
        for (int i = 0; i < 5; i++) {
            if (day >= ((3 + (7 * i))) && (day <= (7 + (7 * i)))) {
                return true;
            }
        }

        return false;
    }


    public static Integer calculateWeekend(Integer day, Map<Food, Integer> orderedMenu) {
        if (checkWeekend(day)) {
            return (2023 * Order.checkMain(orderedMenu));
        }

        return 0;
    }

    private static boolean checkWeekend(Integer day) {
        for (int i = 0; i < 5; i++) {
            if (day >= ((1 + (7 * i))) && (day <= (2 + (7 * i)))) {
                return true;
            }
        }

        return false;
    }

    public static Integer calculateSpecial(Integer day) {
        if (checkSpecial(day)) {
            return 1000;
        }

        return 0;
    }

    private static boolean checkSpecial(Integer day) {
        for (int i = 0; i < 5; i++) {
            if (day == ((3 + (7 * i))) || (day == 25)) {
                return true;
            }
        }

        return false;
    }

    public static Integer giveFreeGift(Integer totalAmount) {
        return (totalAmount / 120000);
    }

    public static Integer calculateFreeGift(Integer totalAmount) {
        return (25000 * giveFreeGift(totalAmount));
    }

    public static Integer calculateTotalDiscount(Integer day, Integer totalAmount, Map<Food, Integer> orderedMenu) {
        return (calculateChristmas(day)
                + calculateWeekday(day, orderedMenu)
                + calculateWeekend(day, orderedMenu)
                + calculateSpecial(day)
                + calculateFreeGift(totalAmount));
    }
}
