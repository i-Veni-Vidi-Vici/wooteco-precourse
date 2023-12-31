package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void beforeEach() {
        bridgeGame = new BridgeGame();
    }

    @DisplayName("다리 이동")
    @Test
    void move() {
        List<String> bridge = List.of("U", "U", "D");

        bridgeGame.move(bridge, "U");
        assertThat(bridgeGame.getResult()).isEqualTo(List.of(List.of("U", "O")));

        bridgeGame.move(bridge, "D");
        assertThat(bridgeGame.getResult()).isEqualTo(List.of(
                List.of("U", "O"),
                List.of("D", "X")));
    }

    @DisplayName("다리 이동 값이 U 또는 D가 아닐 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"A", "UU", "DD", "u", "d"})
    void moveByNotValue(String direction) {
        List<String> bridge = List.of("U", "U", "D");

        assertThatThrownBy(() -> bridgeGame.move(bridge, direction))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작/종료")
    @ParameterizedTest
    @CsvSource(value = {"R,true", "Q,false"})
    void retry(String retryValue, boolean result) {
        assertThat(bridgeGame.retry(retryValue)).isEqualTo(result);
    }

    @DisplayName("총 시도한 횟수 계산")
    @Test
    void countRetry() {
        bridgeGame.retry("R");
        bridgeGame.retry("R");
        bridgeGame.retry("Q");
        assertThat(bridgeGame.getRetryCount()).isEqualTo(3);
    }

    @DisplayName("재시작/종료 값이 R 또는 Q가 아닐 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"A", "RR", "QQ", "r", "q"})
    void retryByNotValue(String retryValue) {
        assertThatThrownBy(() -> bridgeGame.retry(retryValue))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
