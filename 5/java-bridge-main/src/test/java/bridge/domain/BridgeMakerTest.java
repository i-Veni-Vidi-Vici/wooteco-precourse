package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.utility.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeMakerTest {

    @DisplayName("다리 생성, 전달된 값의 크기로 생성")
    @ParameterizedTest
    @ValueSource(ints =  {3,15,20})
    void makeBridge(int size){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        assertThat(bridgeMaker.makeBridge(size).size()).isEqualTo(size);
    }

    @DisplayName("다리 크기가 범위를 벗어날 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(ints =  {0,1,2,21})
    void makeBridgeByNotRange(int size){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
