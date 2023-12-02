package menu.view;

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

    @DisplayName("코치 이름 입력")
    @Test
    void getCoaches() {
        System.setIn(new ByteArrayInputStream("abc,ab".getBytes()));

        assertThat(inputView.getCoaches()).isEqualTo("abc,ab");
    }

    @DisplayName("각 코치들이 못 먹는 메뉴 입력")
    @Test
    void getInedibleMenu() {
        System.setIn(new ByteArrayInputStream("규동,우동".getBytes()));

        assertThat(inputView.getInedibleMenu("포비")).isEqualTo("규동,우동");
    }
}
