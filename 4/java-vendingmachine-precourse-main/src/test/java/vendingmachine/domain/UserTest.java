package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    @DisplayName("상품 구매")
    @Test
    void purchase(){
        User user = new User(3000);

        user.purchase(1500);

        assertThat(user.getMoney()).isEqualTo(1500);
    }
}
