package vendingmachine.constants;

import java.util.LinkedHashMap;
import java.util.Map;

public enum Coin {
    COIN_500("500원", 500),
    COIN_100("100원", 100),
    COIN_50("50원", 50),
    COIN_10("10원", 10);

    private final String name;
    private final int amount;

    Coin(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public static Map<String, Integer> calculate(Integer money) {
        Map<String, Integer> coins = new LinkedHashMap<>();

        coins.put("500원", money / 500);
        money %= 500;

        coins.put("100원", money / 100);
        money %= 100;

        coins.put("50원", money / 50);
        money %= 50;

        coins.put("10원", money / 10);

        return coins;
    }
}
