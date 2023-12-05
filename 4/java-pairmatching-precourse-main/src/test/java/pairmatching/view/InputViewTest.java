package pairmatching.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;

public class InputViewTest {

    private static InputView inputView;

    @BeforeAll
    static void beforeAll() {
        inputView = new InputView();
    }


    @DisplayName("기능 입력")
    @Test
    void getFunction() {
        System.setIn(new ByteArrayInputStream("1".getBytes()));

        assertThat(inputView.getFunction()).isEqualTo("1");
    }

    @DisplayName("페어 매칭 정보 입력")
    @Test
    void getInformation() {
        System.setIn(new ByteArrayInputStream("백엔드, 레벨1, 자동차경주".getBytes()));

        assertThat(inputView.getInformation()).isEqualTo("백엔드, 레벨1, 자동차경주");
    }

    @DisplayName("새로운 매칭 입력")
    @Test
    void getNewMatching() {
        System.setIn(new ByteArrayInputStream("아니오".getBytes()));

        assertThat(inputView.getNewMatching()).isEqualTo("아니오");
    }
}
