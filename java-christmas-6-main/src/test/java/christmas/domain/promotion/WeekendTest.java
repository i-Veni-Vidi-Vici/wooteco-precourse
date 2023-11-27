package christmas.domain.promotion;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constants.Benefit;
import christmas.domain.promotion.discount.Weekend;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WeekendTest {
    @DisplayName("주말 할인, 주말 + 메인 ")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 2,
            8, 9,
            15, 16,
            22, 23,
            29, 30
    })
    void discountWeekend(Integer date) {
        for (int mainCount = 1; mainCount < 3; mainCount++) {
            Weekend weekend = new Weekend(date, mainCount);

            assertThat(weekend.apply().get(Benefit.WEEKEND)).isEqualTo(2023 * mainCount);
        }
    }

    @DisplayName("주말 할인, 주말 + 메인 x")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 2,
            8, 9,
            15, 16,
            22, 23,
            29, 30
    })
    void discountWeekendByNotMain(Integer date) {
        Weekend weekend = new Weekend(date, 0);

        assertThat(weekend.apply().size()).isEqualTo(0);
    }

    @DisplayName("주말 할인, 평일")
    @ParameterizedTest
    @ValueSource(ints = {
            3, 4, 5, 6, 7,
            10, 11, 12, 13, 14,
            17, 18, 19, 20, 21,
            24, 25, 26, 27, 28,
            31
    })
    void discountWeekendByNotWeekend(Integer date) {
        Weekend weekend = new Weekend(date, 1);

        assertThat(weekend.apply().size()).isEqualTo(0);
    }
}
