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

//    public Benefits(Integer date, ReservedMenu reservedMenu) {
//        benefits = new HashMap<>();
//
//        Special special = new Special(date);
//        Weekday weekday = new Weekday(date, reservedMenu);
//        Weekend weekend = new Weekend(date, reservedMenu);
//        Xmas xmas = new Xmas(date);
//        Champagne champagne = new Champagne(date);
//
//        Integer totalAmount = reservedMenu.calculateTotalAmount();
//
//        if (checkTarget(totalAmount)) {
//            benefits.putAll(special.apply());
//            benefits.putAll(weekday.apply());
//            benefits.putAll(weekend.apply());
//            benefits.putAll(xmas.apply());
//            benefits.putAll(champagne.apply());
//
//        }
//    }


    public Benefits(Integer date, ReservedMenu reservedMenu) {
        benefits = new HashMap<>();

        Integer totalAmount = reservedMenu.calculateTotalAmount();

        if (checkTarget(totalAmount)) {
            applyBenefits(date, reservedMenu);
        }
    }

    private void applyBenefits(Integer date, ReservedMenu reservedMenu) {
        applyBenefit(new Special(date));
        applyBenefit(new Weekday(date, reservedMenu));
        applyBenefit(new Weekend(date, reservedMenu));
        applyBenefit(new Xmas(date));
        applyBenefit(new Champagne(date));
    }

    private void applyBenefit(Benefit benefit) {
        benefits.putAll(benefit.apply());
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
            return (Xmas.calculateXmas(day)
                    + Weekday.calculateWeekday(day, reservedMenu)
                    + Weekend.calculateWeekend(day, reservedMenu)
                    + Special.calculateSpecial(day)
                    + Champagne.calculateChampagne(totalAmount));
        }

        return 0;
    }

    public static Integer discount(Integer totalAmount, Integer totalDiscount) {
        return (totalAmount - totalDiscount + Champagne.calculateChampagne(totalAmount));
    }


    public Map<Benefit, Integer> getBenefits() {
        return benefits;
    }
}
