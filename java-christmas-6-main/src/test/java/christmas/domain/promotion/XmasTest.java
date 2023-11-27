package christmas.domain.promotion;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constants.Benefit;
import christmas.domain.promotion.discount.Xmas;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class XmasTest {
    @DisplayName("크리스마스 디데이 할인, 1~25")
    @Test
    void discountXmas() {
        for (int date = 1; date <= 25; date++) {
            Xmas xmas = new Xmas(date);

            assertThat(xmas.apply().get(Benefit.XMAS)).isEqualTo(1000 + ((date - 1) * 100));
        }
    }

    @DisplayName("크리스마스 디데이 할인, 26~31 할인 x")
    @Test
    void discountXmasByNotPeriod() {
        for (int date = 26; date <= 31; date++) {
            Xmas xmas = new Xmas(date);

            assertThat(xmas.apply().size()).isEqualTo(0);
        }
    }
}
