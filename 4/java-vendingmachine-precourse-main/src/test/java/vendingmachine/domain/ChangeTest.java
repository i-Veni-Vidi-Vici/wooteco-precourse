package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ChangeTest {
    @DisplayName("잔돈이 부족할 때")
    @Test
    void giveByInsufficient() {
        Change change = new Change(450);

        Map<String, Integer> coins = new LinkedHashMap<>();
        coins.put("100원", 4);
        coins.put("50원", 1);

        assertThat(change.give(500)).isEqualTo(coins);
    }

    @DisplayName("잔돈이 충분할 때")
    @Test
    void give() {
        Change change = new Change(450);

        Map<String, Integer> coins = new LinkedHashMap<>();
        coins.put("100원", 3);

        assertThat(change.give(300)).isEqualTo(coins);
    }

    @DisplayName("잔돈이 10원 단위가 아닐 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {101,1009})
    void checkMoney(Integer money){
        assertThatThrownBy(() -> new Change(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
