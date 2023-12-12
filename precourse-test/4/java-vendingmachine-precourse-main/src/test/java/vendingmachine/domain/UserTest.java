package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    @DisplayName("상품 금액 지불")
    @Test
    void pay() {
        User user = new User(3000);

        user.pay(1500);

        assertThat(user.getMoney()).isEqualTo(1500);
    }
}
