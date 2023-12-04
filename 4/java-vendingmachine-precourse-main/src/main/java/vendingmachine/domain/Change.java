package vendingmachine.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import vendingmachine.constants.Coin;

public class Change {

    private final Map<String, Integer> coins;
    private final Integer money;

    public Change(Integer money) {
        checkMoney(money);
        this.money = money;
        coins = Coin.calculate(money);
    }

    private void checkMoney(Integer money){
        if ((money % 10) != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 10원 단위 이어야 합니다.");
        }
    }

    public Map<String, Integer> give(Integer userMoney) {
        Map<String, Integer> change = new LinkedHashMap<>();

        if (money <= userMoney) {
            change = removeZero(coins);
        }
        if (money > userMoney) {
            change = removeZero(Coin.calculate(userMoney));
        }

        return change;
    }

    private Map<String, Integer> removeZero(Map<String, Integer> coins) {
        Map<String, Integer> convertedCoins = new LinkedHashMap<>();

        for (String coin : coins.keySet()) {
            if (coins.get(coin) > 0) {
                convertedCoins.put(coin, coins.get(coin));
            }
        }

        return convertedCoins;
    }

    public Map<String, Integer> getCoins() {
        return coins;
    }
}
