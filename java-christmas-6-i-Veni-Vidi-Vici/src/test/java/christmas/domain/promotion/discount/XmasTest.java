package christmas.domain.promotion.discount;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constants.Benefit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class XmasTest {

    @DisplayName("크리스마스 디데이 할인 금액 계산")
    @ParameterizedTest
    @CsvSource(value = {"1,1000", "10,1900", "25,3400"})
    void calculate(Integer date, Integer discountPrice) {
        // given, when
        Xmas xmas = new Xmas(date);

        // then
        assertThat(xmas.apply().get(Benefit.XMAS)).isEqualTo(discountPrice);
    }

    @DisplayName("크리스마스 디데이 할인 금액 계산, 25일 까지")
    @Test
    void calculateUntil25th() {
        for (int date = 1; date <= 25; date++) {
            // given, when
            Xmas xmas = new Xmas(date);

            // then
            assertThat(xmas.apply().get(Benefit.XMAS)).isEqualTo(1000 + (date - 1) * 100);
        }
    }

    @DisplayName("크리스마스 디데이 할인 금액 계산, 25일 이후")
    @Test
    void calculateAfter25th() {
        for (int date = 26; date <= 31; date++) {
            // given, when
            Xmas xmas = new Xmas(date);

            // then
            assertThat(xmas.apply()).isEmpty();
        }
    }
}
