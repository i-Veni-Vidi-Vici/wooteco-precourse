package christmas.view;

import static christmas.constants.Message.BADGE;
import static christmas.constants.Message.BENEFIT_DETAILS;
import static christmas.constants.Message.COLON;
import static christmas.constants.Message.COMMA_INTEGER_FORMAT;
import static christmas.constants.Message.COUNT;
import static christmas.constants.Message.DATE;
import static christmas.constants.Message.DECEMBER;
import static christmas.constants.Message.GIVEAWAY_MENU;
import static christmas.constants.Message.MENU;
import static christmas.constants.Message.MINUS;
import static christmas.constants.Message.NEW_LINE;
import static christmas.constants.Message.NOTHING;
import static christmas.constants.Message.ONE_CHAMPAGNE;
import static christmas.constants.Message.PAYMENT_AMOUNT;
import static christmas.constants.Message.PLANNER;
import static christmas.constants.Message.TOTAL_AMOUNT;
import static christmas.constants.Message.TOTAL_BENEFIT_AMOUNT;
import static christmas.constants.Message.WHITESPACE;
import static christmas.constants.Message.WON;

import christmas.constants.Badge;
import christmas.constants.Benefit;
import christmas.constants.Food;
import java.util.Map;

public class OutputView {

    public static void printPlanner() {
        System.out.println(PLANNER.getMessage());
    }

    public static void printDate(Integer date) {
        System.out.println(DECEMBER.getMessage() + WHITESPACE.getMessage()
                + date + DATE.getMessage() + NEW_LINE.getMessage());
    }

    public static void printMenu(Map<Food, Integer> orderedMenu) {
        System.out.println(MENU.getMessage());

        for (Food food : orderedMenu.keySet()) {
            System.out.println(food.getName() + WHITESPACE.getMessage()
                    + orderedMenu.get(food) + COUNT.getMessage());
        }

        System.out.println();
    }

    public static void printTotalAmount(Integer totalAmount) {
        System.out.println(TOTAL_AMOUNT.getMessage());
        System.out.println(String.format(COMMA_INTEGER_FORMAT.getMessage(), totalAmount) + WON.getMessage());
        System.out.println();
    }

    public static void printGiveaway(boolean giveaway) {
        System.out.println(GIVEAWAY_MENU.getMessage());

        if (giveaway) {
            System.out.println(ONE_CHAMPAGNE.getMessage());
        }
        if (!giveaway) {
            System.out.println(NOTHING.getMessage());
        }

        System.out.println();
    }

    public static void printBenefitDetails(Map<Benefit, Integer> benefits) {
        System.out.println(BENEFIT_DETAILS.getMessage());

        for (Benefit benefit : benefits.keySet()) {
            System.out.println(benefit.getBenefit() + COLON.getMessage() + WHITESPACE.getMessage() + MINUS.getMessage()
                    + String.format(COMMA_INTEGER_FORMAT.getMessage(), benefits.get(benefit)) + WON.getMessage());
        }

        if (benefits.isEmpty()) {
            System.out.println(NOTHING.getMessage());
        }

        System.out.println();
    }

    public static void printTotalBenefitAmount(Integer totalBenefitAmount) {
        System.out.println(TOTAL_BENEFIT_AMOUNT.getMessage());
        System.out.println(MINUS.getMessage() + String.format(COMMA_INTEGER_FORMAT.getMessage(), totalBenefitAmount)
                + WON.getMessage() + NEW_LINE.getMessage());
    }

    public static void printPaymentAmount(Integer paymentAmount) {
        System.out.println(PAYMENT_AMOUNT.getMessage());
        System.out.println(String.format(COMMA_INTEGER_FORMAT.getMessage(), paymentAmount)
                + WON.getMessage() + NEW_LINE.getMessage());
    }

    public static void printBadge(Badge badge) {
        System.out.println(BADGE.getMessage());
        System.out.println(badge.getBadge());
    }

    public void printError(String message){
        System.out.println(message);
    }
}
