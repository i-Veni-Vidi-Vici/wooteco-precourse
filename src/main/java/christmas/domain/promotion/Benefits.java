package christmas.domain.promotion;

import christmas.constants.Benefit;
import christmas.domain.ReservedMenu;
import christmas.domain.promotion.discount.Special;
import christmas.domain.promotion.discount.Weekday;
import christmas.domain.promotion.discount.Weekend;
import christmas.domain.promotion.discount.Xmas;
import christmas.domain.promotion.giveaway.Champagne;
import java.util.HashMap;
import java.util.Map;

public class Benefits {

    private final Map<Benefit, Integer> benefits;

    public Benefits(Integer date, ReservedMenu reservedMenu) {
        benefits = new HashMap<>();

        Special special = new Special(date);
        Weekday weekday = new Weekday(date, reservedMenu);
        Weekend weekend = new Weekend(date, reservedMenu);

        Integer totalAmount = reservedMenu.calculateTotalAmount();

        if (checkTarget(totalAmount)) {
            benefits.putAll(special.apply());
            benefits.putAll(weekday.apply());
            benefits.putAll(weekend.apply());

        }
    }

//    private static void addBenefits(boolean checkBenefit, Benefit benefit, Integer benefitAmount,
//                                    Map<Benefit, Integer> benefits) {
//        if (checkBenefit) {
//            benefits.put(benefit, benefitAmount);
//        }
//    }

    private static boolean checkTarget(Integer totalAmount) {
        return (totalAmount >= 10000);
    }


    public static Integer calculateTotalDiscount(Integer day, Integer totalAmount, ReservedMenu reservedMenu) {
        if (checkTarget(totalAmount)) {
            return (Xmas.calculateChristmas(day)
                    + Weekday.calculateWeekday(day, reservedMenu)
                    + Weekend.calculateWeekend(day, reservedMenu)
                    + Special.calculateSpecial(day)
                    + Champagne.calculateFreeGift(totalAmount));
        }

        return 0;
    }

    public static Integer discount(Integer totalAmount, Integer totalDiscount) {
        return (totalAmount - totalDiscount + Champagne.calculateFreeGift(totalAmount));
    }


    public Map<Benefit, Integer> getBenefits() {
        return benefits;
    }
}
