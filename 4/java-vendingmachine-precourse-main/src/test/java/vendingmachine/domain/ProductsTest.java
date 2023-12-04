package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ProductsTest {

    @DisplayName("상품 가격이 100원 미만일 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {90, 50, 0})
    void createByDeficientPrice(Integer price) {
        assertThatThrownBy(() -> new Products(Collections.singletonMap("콜라", Arrays.asList(price, 1))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상품 가격을 10원으로 나눌 때 나머지가 존재하면, 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {101, 1004})
    void createByRemainder(Integer price) {
        assertThatThrownBy(() -> new Products(Collections.singletonMap("콜라", Arrays.asList(price, 1))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("초기 상품 수량이 0으로 생성될 때, 예외 처리")
    @Test
    void createByCountZero() {
        assertThatThrownBy(() -> new Products(Collections.singletonMap("콜라", Arrays.asList(1000, 0))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상품 판매")
    @Test
    void sell() {
        Products products = new Products(Collections.singletonMap("콜라", Arrays.asList(1000, 3)));

        products.sell("콜라");

        assertThat(products.get().get("콜라").get(1)).isEqualTo(2);
    }
}
