package view;

import static christmas.constants.Message.COUNT;
import static christmas.constants.Message.DATE;
import static christmas.constants.Message.DECEMBER;
import static christmas.constants.Message.MENU;
import static christmas.constants.Message.PAYMENT_AMOUNT;
import static christmas.constants.Message.PLANNER;
import static christmas.constants.Message.WON;
import static christmas.constants.Symbol.MONEY_FORMAT;
import static christmas.constants.Symbol.WHITESPACE;

import java.util.Map;

public class OutputView {

    public void printError(String error) {
        System.out.println(error);
    }

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

    public void printPaymentAmount(Integer paymentAmount) {
        System.out.println(PAYMENT_AMOUNT.getMessage());
        System.out.println(String.format(MONEY_FORMAT.get(), paymentAmount) + WON.getMessage());
        System.out.println();
    }



}
