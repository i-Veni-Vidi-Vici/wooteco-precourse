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
    void calculateChristmas(Integer date, Integer discountPrice) {
        Xmas xmas = new Xmas(date);

        assertThat(xmas.apply().get(Benefit.CHRISTMAS)).isEqualTo(discountPrice);
    }

    @DisplayName("크리스마스 디데이 할인 금액 계산, 25일 까지")
    @Test
    void calculateChristmasUntil25th() {
        for (int date = 1; date <= 25; date++) {
            Xmas xmas = new Xmas(date);
            assertThat(xmas.apply().get(Benefit.CHRISTMAS)).isEqualTo(1000 + (date - 1) * 100);
        }
    }

    @DisplayName("크리스마스 디데이 할인 금액 계산, 25일 이후")
    @Test
    void calculateChristmasAfter25th() {
        for (int date = 26; date <= 31; date++) {
            Xmas xmas = new Xmas(date);
            assertThat(xmas.apply()).isEmpty();
        }
    }
}
