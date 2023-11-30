package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BridgeGameTest {

    @DisplayName("다리 이동")
    @Test
    void move() {
        BridgeGame bridgeGame = new BridgeGame();
        List<String> bridge = List.of("U", "U", "D");

        bridgeGame.move(bridge, "U");
        assertThat(bridgeGame.getResult()).isEqualTo(List.of(List.of("U", "O")));

        bridgeGame.move(bridge, "D");
        assertThat(bridgeGame.getResult()).isEqualTo(List.of(
                List.of("U", "O"),
                List.of("D", "X")));
    }

    @DisplayName("재시작/종료")
    @ParameterizedTest
    @CsvSource(value = {"R,true","Q,false"})
    void retry(String retryValue, boolean result) {
        BridgeGame bridgeGame = new BridgeGame();

        assertThat(bridgeGame.retry(retryValue)).isEqualTo(result);
    }
}
