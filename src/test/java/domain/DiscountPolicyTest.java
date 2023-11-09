package domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.DiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class DiscountPolicyTest {
    @DisplayName("크리스마스 디데이 할인 금액 반환")
    @ParameterizedTest
    @CsvSource(value = {"1,1000", "10,1900", "25,3400", "26, 0", "31,0"})
    void calculateChristmas(Integer day, Integer discountPrice) {
        assertThat(DiscountPolicy.calculateChristmas(day)).isEqualTo(discountPrice);
    }

    @DisplayName("크리스마스 디데이 할인 금액 반환, 25일 까지")
    @Test
    void calculateChristmasUntil25th() {
        for (int day = 1; day <= 25; day++) {
            assertThat(DiscountPolicy.calculateChristmas(day)).isEqualTo(1000 + (day - 1) * 100);
        }
    }

    @DisplayName("크리스마스 디데이 할인 금액 반환, 25일 이후")
    @Test
    void calculateChristmasAfter25th() {
        for (int day = 26; day <= 31; day++) {
            assertThat(DiscountPolicy.calculateChristmas(day)).isEqualTo(0);
        }
    }

    @DisplayName("할인 대상 검증")
    @ParameterizedTest
    @CsvSource(value = {"10000,true", "25000,true", "9999,false", "3000,false"})
    void checkTarget(Integer totalAmount, boolean isTarget) {
        assertThat(DiscountPolicy.checkTarget(totalAmount)).isEqualTo(isTarget);

    }

    @DisplayName("평일 할인 금액 반환, 평일")
    @ParameterizedTest
    @ValueSource(ints = {
            3, 4, 5, 6, 7,
            10, 11, 12, 13, 14,
            17, 18, 19, 20, 21,
            24, 25, 26, 27, 28,
            31
    })
    void calculateWeekdayByWeekday(Integer day) {
        assertThat(DiscountPolicy.calculateWeekday(day)).isEqualTo(2023);
    }

    @DisplayName("평일 할인 금액 반환, 주말")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 2,
            8, 9,
            15, 16,
            22, 23,
            29, 30
    })
    void calculateWeekdayByWeekend(Integer day) {
        assertThat(DiscountPolicy.calculateWeekday(day)).isEqualTo(0);
    }

    @DisplayName("주말 할인 금액 반환, 평일")
    @ParameterizedTest
    @ValueSource(ints = {
            3, 4, 5, 6, 7,
            10, 11, 12, 13, 14,
            17, 18, 19, 20, 21,
            24, 25, 26, 27, 28,
            31
    })
    void calculateWeekendByWeekday(Integer day) {
        assertThat(DiscountPolicy.calculateWeekend(day)).isEqualTo(0);
    }

    @DisplayName("주말 할인 금액 반환, 주말")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 2,
            8, 9,
            15, 16,
            22, 23,
            29, 30
    })
    void calculateWeekendByWeekend(Integer day) {
        assertThat(DiscountPolicy.calculateWeekend(day)).isEqualTo(2023);
    }

    @DisplayName("특별 할인 받는 날, 일요일 + 크리스마스")
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    void calculateSpecial(Integer day) {
        assertThat(DiscountPolicy.calculateSpecial(day)).isEqualTo(1000);
    }

    @DisplayName("특별 할인 받지 못하는 날")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 2,
            4, 5, 6, 7, 8, 9,
            11, 12, 13, 14, 15,
            18, 19, 20, 21, 22,
            26, 27, 28, 29,
    })
    void calculateSpecial(Integer day) {
        assertThat(DiscountPolicy.calculateSpecial(day)).isEqualTo(0);
    }
}
