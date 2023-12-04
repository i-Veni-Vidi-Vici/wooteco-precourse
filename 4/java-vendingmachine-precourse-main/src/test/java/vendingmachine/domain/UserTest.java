package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserTest {
    @DisplayName("상품 구매")
    @Test
    void purchase(){
        User user = new User(3000);

        user.purchase(1500);

        assertThat(user.getMoney()).isEqualTo(1500);
    }

    @DisplayName("상품 구매시, 보유한 금액이 상품 가격보다 적을 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {1499, 1000, 0})
    void purchaseByLackOfMoney (Integer money){
        User user = new User(money);

        assertThatThrownBy(() -> user.purchase(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
