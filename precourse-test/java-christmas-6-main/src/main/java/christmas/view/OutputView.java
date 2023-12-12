package christmas.view;

import static christmas.constants.Message.AMOUNT;
import static christmas.constants.Message.BADGE;
import static christmas.constants.Message.BENEFITS;
import static christmas.constants.Message.BENEFIT_AMOUNT;
import static christmas.constants.Message.COUNT;
import static christmas.constants.Message.DATE;
import static christmas.constants.Message.DECEMBER;
import static christmas.constants.Message.GIVEAWAY_ITEM;
import static christmas.constants.Message.GIVEAWAY_TITLE;
import static christmas.constants.Message.MENU;
import static christmas.constants.Message.NOTHING;
import static christmas.constants.Message.PAYMENT_AMOUNT;
import static christmas.constants.Message.PLANNER;
import static christmas.constants.Message.WON;
import static christmas.constants.Symbol.COLON;
import static christmas.constants.Symbol.HYPHEN;
import static christmas.constants.Symbol.MONEY_FORMAT;
import static christmas.constants.Symbol.WHITESPACE;
import static christmas.constants.Value.ZERO;

import christmas.constants.Badge;
import christmas.constants.Benefit;
import christmas.constants.Food;
import java.util.Map;

public class OutputView {
    public void printPlanner() {
        System.out.println(PLANNER.getMessage());
    }

    public void printDate(Integer date) {
        System.out.println(DECEMBER.getMessage() + WHITESPACE.get() + date + DATE.getMessage());
        System.out.println();
    }

    public void printMenu(Map<Food, Integer> reservedMenu) {
        System.out.println(MENU.getMessage());

        for (Food food : reservedMenu.keySet()) {
            System.out.println(food.getName() + WHITESPACE.get() + reservedMenu.get(food) + COUNT.getMessage());
        }

        System.out.println();
    }

    public void printAmount(Integer amount) {
        System.out.println(AMOUNT.getMessage());
        System.out.println(String.format(MONEY_FORMAT.get(), amount) + WON.getMessage());
        System.out.println();
    }

    public void printGiveaway(boolean hasGiveaway) {
        System.out.println(GIVEAWAY_TITLE.getMessage());

        if (hasGiveaway) {
            System.out.println(GIVEAWAY_ITEM.getMessage());
            System.out.println();
            return;
        }

        System.out.println(NOTHING.getMessage());
        System.out.println();
    }


    public void printBenefits(Map<Benefit, Integer> benefits) {
        System.out.println(BENEFITS.getMessage());

        if (benefits.isEmpty()) {
            System.out.println(NOTHING.getMessage());
            System.out.println();
            return;
        }

        for (Benefit benefit : benefits.keySet()) {
            System.out.println(benefit.get() + COLON.get() + WHITESPACE.get() + HYPHEN.get()
                    + String.format(MONEY_FORMAT.get(), benefits.get(benefit)) + WON.getMessage());
        }

        System.out.println();
    }

    public void printBenefitAmount(Integer benefitAmount) {
        System.out.println(BENEFIT_AMOUNT.getMessage());

        if (benefitAmount > 0) {
            System.out.println(HYPHEN.get() + String.format(MONEY_FORMAT.get(), benefitAmount) + WON.getMessage());
            System.out.println();
            return;
        }

        System.out.println(ZERO.get() + WON.getMessage());
        System.out.println();
    }

    public void printPaymentAmount(Integer paymentAmount) {
        System.out.println(PAYMENT_AMOUNT.getMessage());
        System.out.println(String.format(MONEY_FORMAT.get(), paymentAmount) + WON.getMessage());
        System.out.println();
    }

    public void printBadge(Badge badge) {
        System.out.println(BADGE.getMessage());
        System.out.println(badge.get());
    }

    public void printError(String error) {
        System.out.println(error);
    }
}
