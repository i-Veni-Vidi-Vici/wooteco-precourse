package menu.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InedibleMenusTest {

    @DisplayName("못 먹는 메뉴 개수가 범위를 벗어날 때")
    @Test
    void checkCount() {
        assertThatThrownBy(() -> new InedibleMenus(List.of("규동", "우동", "미소시루")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("못 먹는 메뉴가 중복될 때")
    @Test
    void checkDuplication() {
        assertThatThrownBy(() -> new InedibleMenus(List.of("규동", "규동", "우동")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("못 먹는 메뉴가 존재하지 않을 때")
    @ParameterizedTest
    @ValueSource(strings = {"규동1", "과자1", "일식"})
    void checkMenu(String menu) {
        assertThatThrownBy(() -> new InedibleMenus(List.of(menu)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
