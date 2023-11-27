package christmas.domain.promotion;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constants.Benefit;
import christmas.domain.promotion.discount.Weekday;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WeekdayTset {
    @DisplayName("평일 할인, 평일 + 디저트 ")
    @ParameterizedTest
    @ValueSource(ints = {
            3, 4, 5, 6, 7,
            10, 11, 12, 13, 14,
            17, 18, 19, 20, 21,
            24, 25, 26, 27, 28,
            31
    })
    void discountWeekday(Integer date) {
        for (int dessertCount = 1; dessertCount < 3; dessertCount++) {
            Weekday weekday = new Weekday(date, dessertCount);

            assertThat(weekday.apply().get(Benefit.WEEKDAY)).isEqualTo(2023 * dessertCount);
        }
    }

    @DisplayName("평일 할인, 주말")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 2,
            8, 9,
            15, 16,
            22, 23,
            29, 30
    })
    void discountWeekdayByNotWeekday(Integer date) {
        Weekday weekday = new Weekday(date, 1);

        assertThat(weekday.apply().size()).isEqualTo(0);
    }

    @DisplayName("평일 할인, 평일 + 디저트x ")
    @ParameterizedTest
    @ValueSource(ints = {
            3, 4, 5, 6, 7,
            10, 11, 12, 13, 14,
            17, 18, 19, 20, 21,
            24, 25, 26, 27, 28,
            31
    })
    void discountWeekdayByNotDessert(Integer date) {
        Weekday weekday = new Weekday(date, 0);

        assertThat(weekday.apply().size()).isEqualTo(0);
    }

}
