package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoMachineTest {

    private static LottoMachine lottoMachine;

    @BeforeAll
    static void beforeAll(){
        lottoMachine = new LottoMachine();
    }

    @DisplayName("구입 금액만큼 로또 발행")
    @Test
    void generate() {
        assertThat(lottoMachine.generate(5000).size()).isEqualTo(5);
    }

    @DisplayName("구입 금액이 1,000단위가 아닐 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {0, 999, 1001})
    void generate(Integer money) {
        assertThatThrownBy(() -> lottoMachine.generate(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
