package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class benefitTest {

    @DisplayName("크리스마스 디데이 할인, 1~25")
    @Test
    void discountXmas() {
        Benefit benefit = new Benefit();

        for (int date = 1; date <= 25; date++) {
            assertThat(benefit.discountXmas(date)).isEqualTo(1000 + ((date - 1) * 100));
        }
    }

    @DisplayName("크리스마스 디데이 할인, 26~31 할인 x")
    @Test
    void discountXmasByNotPeriod() {
        Benefit benefit = new Benefit();

        for (int date = 26; date <= 31; date++) {
            assertThat(benefit.discountXmas(date)).isEqualTo(0);
        }
    }

    @DisplayName("평일 할인, 평일 + 디저트 1개")
    @ParameterizedTest
    @ValueSource(ints = {
            3, 4, 5, 6, 7,
            10, 11, 12, 13, 14,
            17, 18, 19, 20, 21,
            24, 25, 26, 27, 28,
            31
    })
    void discountWeekday(Integer date) {
        Benefit benefit = new Benefit();

        assertThat(benefit.discountWeekday(date, 1)).isEqualTo(2023);
    }

    @DisplayName("평일 할인, 평일x")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 2,
            8, 9,
            15, 16,
            22, 23,
            29, 30
    })
    void discountWeekdayByNotWeekday(Integer date) {
        Benefit benefit = new Benefit();

        assertThat(benefit.discountWeekday(date, 1)).isEqualTo(0);
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
        Benefit benefit = new Benefit();

        assertThat(benefit.discountWeekday(date, 0)).isEqualTo(0);
    }
}
