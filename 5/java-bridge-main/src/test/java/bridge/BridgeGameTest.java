package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    @DisplayName("다리 이동")
    @Test
    void move(){
        BridgeGame bridgeGame = new BridgeGame();
        List<String> bridge = List.of("U", "U", "D");

        bridgeGame.move(bridge,"U");
        assertThat(bridgeGame.getResult()).isEqualTo(List.of(List.of("U","O")));

        bridgeGame.move(bridge,"D");
        assertThat(bridgeGame.getResult()).isEqualTo(List.of(
                List.of("U","O"),
                List.of("D","X")));
    }
}
