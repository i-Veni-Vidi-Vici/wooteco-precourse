package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ReservedDateTest {

    @DisplayName("범위를 벗어날 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {-1,0,32})
    void reservedDate(Integer date){
        assertThatThrownBy(() -> new ReservedDate(date))
                .isInstanceOf(IllegalArgumentException.class);
    }
}