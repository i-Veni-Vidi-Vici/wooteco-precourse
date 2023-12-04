package vendingmachine.constants;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CoinTest {

    @DisplayName("동전 개수 계산")
    @Test
    void calculate(){
        Map<String, Integer> coins = new LinkedHashMap<>();
        coins.put("500원", 0);
        coins.put("100원", 4);
        coins.put("50원", 1);
        coins.put("10원", 0);

        assertThat(Coin.calculate(450)).isEqualTo(coins);
    }
}
