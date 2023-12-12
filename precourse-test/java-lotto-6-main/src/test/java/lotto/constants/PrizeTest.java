package lotto.constants;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeTest {

    @DisplayName("당첨 순위 계산, 1등")
    @Test
    void calculateByFirst() {
        assertThat(Prize.calculate(6, false)).isEqualTo(Prize.FIRST);
    }

    @DisplayName("당첨 순위 계산, 2등")
    @Test
    void calculateBySecond() {
        assertThat(Prize.calculate(5, true)).isEqualTo(Prize.SECOND);
    }

    @DisplayName("당첨 순위 계산, 3등")
    @Test
    void calculateByThird() {
        assertThat(Prize.calculate(5, false)).isEqualTo(Prize.THIRD);
    }

    @DisplayName("당첨 순위 계산, 4등")
    @Test
    void calculateByFourth() {
        assertThat(Prize.calculate(4, true)).isEqualTo(Prize.FOURTH);
        assertThat(Prize.calculate(4, false)).isEqualTo(Prize.FOURTH);
    }

    @DisplayName("당첨 순위 계산, 5등")
    @Test
    void calculateByFifth() {
        assertThat(Prize.calculate(3, true)).isEqualTo(Prize.FIFTH);
        assertThat(Prize.calculate(3, false)).isEqualTo(Prize.FIFTH);
    }

    @DisplayName("당첨 순위 계산, 당첨x")
    @Test
    void calculateByNothing() {
        assertThat(Prize.calculate(2, true)).isNull();
        assertThat(Prize.calculate(1, true)).isNull();
        assertThat(Prize.calculate(0, true)).isNull();
    }
}
