package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    void discountXmas() {
        Benefit benefit = new Benefit();

        for (int date = 26; date <= 31; date++) {
            assertThat(benefit.discountXmas(date)).isEqualTo(0);
        }
    }
}
