package vendingmachine.constants;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CoinTest {

    @DisplayName("동전 개수 계산")
    @Test
    void calculate(){
        assertThat(Coin.calculate(450)).isEqualTo(Arrays.asList(0,4,1,0));
    }
}
