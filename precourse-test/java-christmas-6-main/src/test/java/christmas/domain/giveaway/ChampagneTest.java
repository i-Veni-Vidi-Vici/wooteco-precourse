package christmas.domain.giveaway;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constants.Benefit;
import christmas.domain.promotion.giveaway.Champagne;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ChampagneTest {
    @DisplayName("증정 이벤트, 12만원 이상일 때 샴페인 증정")
    @ParameterizedTest
    @ValueSource(ints = {120_000, 150_000})
    void presentGiveaway(Integer purchaseAmount) {
        Champagne champagne = new Champagne(purchaseAmount);

        assertThat(champagne.apply().get(Benefit.GIVEAWAY)).isEqualTo(25_000);
    }

    @DisplayName("증정 이벤트, 12만원 미만일 때 증정x")
    @ParameterizedTest
    @ValueSource(ints = {0, 119_000})
    void presentGiveawayByNotApplicable(Integer purchaseAmount) {
        Champagne champagne = new Champagne(purchaseAmount);

        assertThat(champagne.apply().size()).isEqualTo(0);
    }
}
