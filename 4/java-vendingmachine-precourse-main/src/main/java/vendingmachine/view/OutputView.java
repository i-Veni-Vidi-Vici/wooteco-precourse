package vendingmachine.view;

import java.util.Map;

public class OutputView {

    public void printError(String error) {
        System.out.println(error);
    }

    public void printCoin(Map<String, Integer> coins) {
        System.out.println();
        System.out.println("자판기가 보유한 동전");

        for (String coin : coins.keySet()) {
            System.out.println(coin + " - " + coins.get(coin) + "개");
        }
    }

    public void printMoney(Integer money) {
        System.out.println();
        System.out.println("투입 금액: " + money + "원");
    }

    public void printChange(Map<String, Integer> change) {
        System.out.println("잔돈");

        for (String coin : change.keySet()) {
            System.out.println(coin + " - " + change.get(coin) + "개");
        }
    }
}
