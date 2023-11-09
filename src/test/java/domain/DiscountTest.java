package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DiscountTest {
    @DisplayName("크리스마스 디데이 할인 금액 반환")
    @ParameterizedTest
    @CsvSource(value = {"1,1000", "25,3400"})
    void discountChristmas(Integer day, Integer discountPrice) {
        assertThat(discountChristmas(day)).isEqualTo(discountPrice);
    }

    @DisplayName("할인 대상 검증")
    @ParameterizedTest
    @CsvSource(value = {"10000,true","25000,true","9999,false","3000,false"})
    void checkDiscountTarget(Integer totalAmount, boolean isTarget){
        assertThat(checkDiscountTarget(totalAmount)).isEqualTo(isTarget);

    }
}
