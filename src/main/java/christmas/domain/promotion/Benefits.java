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

        Integer totalAmount = reservedMenu.calculateTotalAmount();

        if (checkTarget(totalAmount)) {
            applyBenefits(date, totalAmount, reservedMenu);
        }
    }

    private void applyBenefits(Integer date, Integer totalAmount, ReservedMenu reservedMenu) {
        addBenefit(new Special(date));
        addBenefit(new Weekday(date, reservedMenu));
        addBenefit(new Weekend(date, reservedMenu));
        addBenefit(new Xmas(date));
        addBenefit(new Champagne(totalAmount));
    }

    private void addBenefit(Promotion promotion) {
        benefits.putAll(promotion.apply());
    }

    private boolean checkTarget(Integer totalAmount) {
        return (totalAmount >= 10000);
    }

    public Integer calculateTotalDiscount() {

    }

    public Integer discount(Integer totalAmount, Integer totalDiscount) {
        return (totalAmount - totalDiscount + Champagne.calculateChampagne(totalAmount));
    }


    public Map<Benefit, Integer> getBenefits() {
        return benefits;
    }
}
