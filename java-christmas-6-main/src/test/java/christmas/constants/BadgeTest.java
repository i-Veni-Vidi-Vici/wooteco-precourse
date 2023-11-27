package christmas.constants;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BadgeTest {

    @DisplayName("배지 부여")
    @ParameterizedTest
    @CsvSource(value = {"0,없음","5000,별","10000,트리","20000,산타"})
    void grantBadge(Integer benefitAmount, String badge){
        assertThat(Badge.grant(benefitAmount).getBadge()).isEqualTo(badge);
    }
}
