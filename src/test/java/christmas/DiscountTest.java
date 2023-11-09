package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DiscountTest {
    @DisplayName("크리스마스 디데이 할인 금액 반환")
    @ParameterizedTest
    @CsvSource(value = {"1,1000", "25,3400"})
    void discountChristmas(Integer day, Integer discountPrice){
        assertThat(discountChristmas(day)).isEqualTo(discountPrice);
    }
}
