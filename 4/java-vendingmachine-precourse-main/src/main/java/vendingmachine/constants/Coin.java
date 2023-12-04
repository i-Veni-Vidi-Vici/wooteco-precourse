package vendingmachine.constants;

import java.util.ArrayList;
import java.util.List;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static List<Integer> calculate(Integer money){
        List<Integer> coins = new ArrayList<>();

        coins.add(money / 500);
        money %= 500;

        coins.add(money / 100);
        money %= 100;

        coins.add(money / 50);
        money %= 50;

        coins.add(money / 10);

        return coins;
    }
}
