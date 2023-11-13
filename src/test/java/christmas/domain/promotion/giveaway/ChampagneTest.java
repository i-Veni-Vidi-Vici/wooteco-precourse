package christmas.domain.promotion.giveaway;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constants.Benefit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ChampagneTest {
    @DisplayName("증정 이벤트 금액 계산, 12만원 이상 => 25,000원")
    @ParameterizedTest
    @ValueSource(ints = {120000, 150000, 240000})
    void checkFreeGift(Integer totalAmount) {
        Champagne champagne = new Champagne(totalAmount);
        assertThat(champagne.apply().get(Benefit.GIVEAWAY)).isEqualTo(25000);
    }

    @DisplayName("증정 이벤트 금액 계산, 12만원 미만 => not apply")
    @ParameterizedTest
    @ValueSource(ints = {0, 50000, 119999})
    void calculateFreeGift(Integer totalAmount) {
        Champagne champagne = new Champagne(totalAmount);
        assertThat(champagne.apply()).isEmpty();
    }
}
