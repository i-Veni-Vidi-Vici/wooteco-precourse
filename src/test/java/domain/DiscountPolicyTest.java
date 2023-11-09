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
    @CsvSource(value = {"1,1000", "25,3400", "26, 0","31,0"})
    void calculateChristmas(Integer day, Integer discountPrice) {
        assertThat(DiscountPolicy.calculateChristmas(day)).isEqualTo(discountPrice);
    }

    @DisplayName("할인 대상 검증")
    @ParameterizedTest
    @CsvSource(value = {"10000,true", "25000,true", "9999,false", "3000,false"})
    void checkTarget(Integer totalAmount, boolean isTarget) {
        assertThat(DiscountPolicy.checkTarget(totalAmount)).isEqualTo(isTarget);

    }

    @DisplayName("크리스마스 디데이 기간 체크")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "25,true", "26,false", "31,false"})
    void checkChristmasPeriod(Integer day, boolean isPeriod) {
        assertThat(DiscountPolicy.checkChristmasPeriod(day)).isEqualTo(isPeriod);
    }

    @DisplayName("평일 할인 금액 반환")
    @ParameterizedTest
    @CsvSource(value = {"1,0", "9,0", "5,2023", "29,0", "31,2023"})
    void calculateWeekday(Integer day, Integer discountPrice) {
        assertThat(DiscountPolicy.calculateWeekday(day)).isEqualTo(discountPrice);
    }

    @DisplayName("평일 기간 체크, 주말")
    @ParameterizedTest
    @ValueSource(ints = {
            1, 2,
            8, 9,
            15, 16,
            22, 23,
            29, 30
    })
    void checkWeekdayPeriodByWeekend(Integer day) {
        assertThat(DiscountPolicy.checkWeekdayPeriod(day)).isEqualTo(false);
    }

    @DisplayName("평일 기간 체크, 평일")
    @ParameterizedTest
    @ValueSource(ints = {
            3, 4, 5, 6, 7,
            10, 11, 12, 13, 14,
            17, 18, 19, 20, 21,
            24, 25, 26, 27, 28,
            31
    })
    void checkWeekdayPeriodByWeekday(Integer day) {
        assertThat(DiscountPolicy.checkWeekdayPeriod(day)).isEqualTo(true);
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
    void calculateWeekendByWeekend(Integer day){
        assertThat(DiscountPolicy.calculateWeekend(day)).isEqualTo(2023);
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
    void calculateWeekendByWeekday(Integer day){
        assertThat(DiscountPolicy.calculateWeekend(day)).isEqualTo(0);
    }
}
