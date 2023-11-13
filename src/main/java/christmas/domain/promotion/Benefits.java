package christmas.domain.promotion;

import christmas.constants.Benefit;
import christmas.domain.ReservedMenu;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Benefits {

    private final Map<Benefit, Integer> benefits;

    public Benefits(Integer day, ReservedMenu reservedMenu) {
        Map<Benefit, Integer> temporaryBenefits = new HashMap<>();
        Integer totalAmount = reservedMenu.calculateTotalAmount();

        if (checkTarget(totalAmount)) {
            addBenefits(checkChristmasPeriod(day),Benefit.CHRISTMAS, calculateChristmas(day), temporaryBenefits);
            addBenefits(checkWeekday(day),Benefit.WEEKDAY, calculateWeekday(day, reservedMenu), temporaryBenefits);
            addBenefits(checkWeekend(day), Benefit.WEEKEND, calculateWeekend(day, reservedMenu), temporaryBenefits);
            addBenefits(checkSpecial(day), Benefit.SPECIAL, calculateSpecial(day), temporaryBenefits);
            addBenefits(checkFreeGift(totalAmount), Benefit.FREE_GIFT,calculateFreeGift(totalAmount), temporaryBenefits);
        }

        benefits = Collections.unmodifiableMap(temporaryBenefits);
    }

    private static void addBenefits(boolean checkBenefit, Benefit benefit, Integer benefitAmount,
                                    Map<Benefit, Integer> benefits) {
        if (checkBenefit) {
            benefits.put(benefit, benefitAmount);
        }
    }

    private static boolean checkTarget(Integer totalAmount) {
        return (totalAmount >= 10000);
    }

    public static Integer calculateChristmas(Integer day) {
        if (checkChristmasPeriod(day)) {
            return (1000 + ((day - 1) * 100));
        }

        return 0;
    }

    private static boolean checkChristmasPeriod(Integer day) {
        return (day <= 25);
    }

    public static Integer calculateWeekday(Integer day, ReservedMenu reservedMenu) {
        if (checkWeekday(day)) {
            return (2023 * reservedMenu.countDessert());
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


    public static Integer calculateWeekend(Integer day, ReservedMenu reservedMenu) {
        if (checkWeekend(day)) {
            return (2023 * reservedMenu.countMain());
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

    public static boolean checkFreeGift(Integer totalAmount) {
        return ((totalAmount / 120000) > 0);
    }

    public static Integer calculateFreeGift(Integer totalAmount) {
        if (checkFreeGift(totalAmount)) {
            return 25000;
        }
        return 0;
    }

    public static Integer calculateTotalDiscount(Integer day, Integer totalAmount, ReservedMenu reservedMenu) {
        if (checkTarget(totalAmount)) {
            return (calculateChristmas(day)
                    + calculateWeekday(day, reservedMenu)
                    + calculateWeekend(day, reservedMenu)
                    + calculateSpecial(day)
                    + calculateFreeGift(totalAmount));
        }

        return 0;
    }

    public static Integer discount(Integer totalAmount, Integer totalDiscount) {
        return (totalAmount - totalDiscount + calculateFreeGift(totalAmount));
    }


    public Map<Benefit, Integer> getBenefits() {
        return benefits;
    }
}
