package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {
    @DisplayName("번호 개수가 6개가 아닐 때, 예외 처리")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 번호가 있을 때, 예외 처리")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호가 범위를 벗어날 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void createLottoByNotRange(Integer notLottoNumber) {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, notLottoNumber)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}