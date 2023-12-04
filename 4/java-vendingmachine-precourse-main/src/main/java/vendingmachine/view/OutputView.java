package vendingmachine.view;

import static vendingmachine.constants.Message.CHANGE;
import static vendingmachine.constants.Message.COIN;
import static vendingmachine.constants.Message.COUNT;
import static vendingmachine.constants.Message.MONEY;
import static vendingmachine.constants.Message.WON;
import static vendingmachine.constants.Symbol.HYPHEN;
import static vendingmachine.constants.Symbol.WHITESPACE;

import java.util.Map;

public class OutputView {

    public void printError(String error) {
        System.out.println(error);
    }

    public void printCoin(Map<String, Integer> coins) {
        System.out.println();
        System.out.println(COIN.getMessage());

        for (String coin : coins.keySet()) {
            System.out.println(
                    coin + WHITESPACE.get() + HYPHEN.get() + WHITESPACE.get() + coins.get(coin) + COUNT.getMessage());
        }
    }

    public void printMoney(Integer money) {
        System.out.println();
        System.out.println(MONEY.getMessage() + money + WON.getMessage());
    }

    public void printChange(Map<String, Integer> change) {
        System.out.println(CHANGE.getMessage());

        for (String coin : change.keySet()) {
            System.out.println(
                    coin + WHITESPACE.get() + HYPHEN.get() + WHITESPACE.get() + change.get(coin) + COUNT.getMessage());
        }
    }
}
