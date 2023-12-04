package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChangeTest {
    @DisplayName("잔돈으로 반환할 수 있는 금액만 거슬러 주기")
    @Test
    void give() {
        Change change = new Change();
        assertThat(change.give(500)).isEqualTo(Collections.singletonMap("100원", 4, "50원", 1));
    }
}
