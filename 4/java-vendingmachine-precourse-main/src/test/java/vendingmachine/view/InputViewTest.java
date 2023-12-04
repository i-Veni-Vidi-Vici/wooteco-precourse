package vendingmachine.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    private static InputView inputView;

    @BeforeAll
    static void beforeAll() {
        inputView = new InputView();
    }

    @DisplayName("자판기 보유 금액 입력")
    @Test
    void getHavingMoney() {
        System.setIn(new ByteArrayInputStream("100".getBytes()));

        assertThat(inputView.getHavingMoney()).isEqualTo("100");
    }

    @DisplayName("판매할 상품 입력")
    @Test
    void getProduct() {
        System.setIn(new ByteArrayInputStream("[콜라,1500,20]".getBytes()));

        assertThat(inputView.getProduct()).isEqualTo("[콜라,1500,20]");
    }

    @DisplayName("투입 금액 입력")
    @Test
    void getMoney() {
        System.setIn(new ByteArrayInputStream("3000".getBytes()));

        assertThat(inputView.getMoney()).isEqualTo("3000");
    }

    @DisplayName("구매할 상품명 입력")
    @Test
    void getPurchase() {
        System.setIn(new ByteArrayInputStream("콜라".getBytes()));

        assertThat(inputView.getPurchase()).isEqualTo("콜라");
    }
}
