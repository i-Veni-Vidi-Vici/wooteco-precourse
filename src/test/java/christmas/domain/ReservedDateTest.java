package christmas.domain;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ReservedDateTest {

    @DisplayName("날짜 범위에 포함될 때, 예외 처리 x")
    @ParameterizedTest
    @ValueSource(ints = {1, 25, 31})
    void checkRange(Integer reservedDate) {
        assertDoesNotThrow(() -> new ReservedDate(reservedDate));
    }

    @DisplayName("날짜 범위를 벗어날 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 32})
    void checkRangeByOutOfRange(Integer reservedDate) {
        assertThatThrownBy(() -> new ReservedDate(reservedDate))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
