package domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.DiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DiscountPolicyTest {
    @DisplayName("크리스마스 디데이 할인 금액 반환")
    @ParameterizedTest
    @CsvSource(value = {"1,1000", "25,3400"})
    void calculateChristmas(Integer day, Integer discountPrice) {
        assertThat(DiscountPolicy.calculateChristmas(day)).isEqualTo(discountPrice);
    }

    @DisplayName("할인 대상 검증")
    @ParameterizedTest
    @CsvSource(value = {"10000,true","25000,true","9999,false","3000,false"})
    void checkTarget(Integer totalAmount, boolean isTarget){
        assertThat(DiscountPolicy.checkTarget(totalAmount)).isEqualTo(isTarget);

    }

    @DisplayName("크리스마스 디데이 기간 체크")
    @ParameterizedTest
    @CsvSource(value = {"1,true","25,true","26,false","31,false"})
    void checkChristmasPeriod(Integer day, boolean isPeriod){
        assertThat(DiscountPolicy.checkChristmasPeriod(day)).isEqualTo(isPeriod);
    }
}
