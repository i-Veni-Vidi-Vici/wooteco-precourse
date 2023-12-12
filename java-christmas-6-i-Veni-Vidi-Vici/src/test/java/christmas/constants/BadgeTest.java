package christmas.constants;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BadgeTest {

    @DisplayName("총 혜택 금액에 따라, 배지 부여 - 산타")
    @ParameterizedTest
    @ValueSource(ints = {20000, 25000})
    void grantBadgeBySanta(Integer totalDiscount) {
        assertThat(Badge.grant(totalDiscount)).isEqualTo(Badge.SANTA);
    }

    @DisplayName("총 혜택 금액에 따라, 배지 부여 - 트리")
    @ParameterizedTest
    @ValueSource(ints = {10000, 19999})
    void grantBadgeByTree(Integer totalDiscount) {
        assertThat(Badge.grant(totalDiscount)).isEqualTo(Badge.TREE);
    }

    @DisplayName("총 혜택 금액에 따라, 배지 부여 - 트리")
    @ParameterizedTest
    @ValueSource(ints = {5000, 9999})
    void grantBadgeByStar(Integer totalDiscount) {
        assertThat(Badge.grant(totalDiscount)).isEqualTo(Badge.STAR);
    }

    @DisplayName("총 혜택 금액에 따라, 배지 부여 - 트리")
    @ParameterizedTest
    @ValueSource(ints = {0, 4999})
    void grantBadgeByNothing(Integer totalDiscount) {
        assertThat(Badge.grant(totalDiscount)).isEqualTo(Badge.NOTHING);
    }
}

