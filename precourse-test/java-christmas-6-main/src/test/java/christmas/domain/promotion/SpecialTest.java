package christmas.domain.promotion;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constants.Benefit;
import christmas.domain.promotion.discount.Special;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SpecialTest {
    @DisplayName("특별 할인, 별표 날")
    @ParameterizedTest
    @ValueSource(ints = {
            3, 10, 17, 24, 25, 31
    })
    void discountSpecial(Integer date) {
        Special special = new Special(date);

        assertThat(special.apply().get(Benefit.SPECIAL)).isEqualTo(1000);
    }

    @DisplayName("특별 할인, 별표 날x")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 2,
            4, 5, 6, 7, 8, 9,
            11, 12, 13, 14, 15, 16,
            18, 19, 20, 21, 22, 23,
            26, 27, 28, 29, 30
    })
    void discountSpecialByNotSpecialDay(Integer date) {
        Special special = new Special(date);

        assertThat(special.apply().size()).isEqualTo(0);
    }

}
