package christmas.domain.promotion;

import christmas.constants.Benefit;
import christmas.constants.Food;
import christmas.domain.ReservedDate;
import christmas.domain.ReservedMenu;
import christmas.domain.promotion.discount.Special;
import christmas.domain.promotion.discount.Weekday;
import christmas.domain.promotion.discount.Weekend;
import christmas.domain.promotion.discount.Xmas;
import christmas.domain.promotion.giveaway.Champagne;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Benefits {
    private final Map<Benefit, Integer> benefits;
    private final Integer amount;

    public Benefits(ReservedDate reservedDate, ReservedMenu reservedMenu) {
        amount = reservedMenu.calculateAmount();
        benefits = new HashMap<>();
        create(reservedDate, reservedMenu);
    }

    private void create(ReservedDate reservedDate, ReservedMenu reservedMenu) {
        if (isTarget(amount)) {
            apply(new Xmas(reservedDate.get()));
            apply(new Weekday(reservedDate.get(), reservedMenu.countDessert()));
            apply(new Weekend(reservedDate.get(), reservedMenu.countMain()));
            apply(new Special(reservedDate.get()));
            apply(new Champagne(amount));
        }
    }

    private void apply(Promotion promotion) {
        benefits.putAll(promotion.apply());
    }

    private boolean isTarget(Integer purchaseAmount) {
        return (purchaseAmount >= 10_000);
    }

    public boolean checkGiveaway() {
        return benefits.containsKey(Benefit.GIVEAWAY);
    }

    public Integer calculateBenefitAmount() {
        if (checkGiveaway()) {
            return (calculateDiscountAmount() + Food.CHAMPAGNE.getPrice());
        }

        return calculateDiscountAmount();
    }

    public Integer calculatePaymentAmount() {
        return (amount - calculateDiscountAmount());
    }

    private Integer calculateDiscountAmount() {
        Integer discountAmount = 0;

        for (Benefit benefit : benefits.keySet()) {
            if (benefit == Benefit.GIVEAWAY) {
                continue;
            }

            discountAmount += benefits.get(benefit);
        }

        return discountAmount;
    }


    public Map<Benefit, Integer> get() {
        return Collections.unmodifiableMap(benefits);
    }
}
