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

        coins.put(COIN_500.name, money / COIN_500.amount);
        money %= COIN_500.amount;

        coins.put(COIN_100.name, money / COIN_100.amount);
        money %= COIN_100.amount;

        coins.put(COIN_50.name, money / COIN_50.amount);
        money %= COIN_50.amount;

        coins.put(COIN_10.name, money / COIN_10.amount);

        return coins;
    }
}
