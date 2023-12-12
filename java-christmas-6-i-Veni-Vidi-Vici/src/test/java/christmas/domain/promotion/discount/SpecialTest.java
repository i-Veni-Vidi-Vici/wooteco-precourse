package christmas.domain.promotion.discount;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constants.Benefit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SpecialTest {

    @DisplayName("특별 할인 받는 날 = 일요일 or 크리스마스 => 1000원 할인")
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    void calculateByTheDay(Integer date) {
        // given, when
        Special special = new Special(date);

        // then
        assertThat(special.apply().get(Benefit.SPECIAL)).isEqualTo(1000);
    }

    @DisplayName("특별 할인 받지 못하는 날 => not apply")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 2,
            4, 5, 6, 7, 8, 9,
            11, 12, 13, 14, 15,
            18, 19, 20, 21, 22,
            26, 27, 28, 29
    })
    void calculateByNotTheDay(Integer date) {
        // given, when
        Special special = new Special(date);

        // then
        assertThat(special.apply()).isEmpty();
    }
}
