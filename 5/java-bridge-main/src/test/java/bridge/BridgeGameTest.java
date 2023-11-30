package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    @DisplayName("다리 이동")
    @Test
    void move(){
        BridgeGame bridgeGame = new BridgeGame();

        bridgeGame.move();
        assertThat(bridgeGame.getResult()).isEqualTo();
    }
}
