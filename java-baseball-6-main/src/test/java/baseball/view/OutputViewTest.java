package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class OutputViewTest {

    @DisplayName("게임 시작 문구 출력")
    @Test
    void printStart(){
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        OutputView outputView = new OutputView();

        outputView.printStart();

        assertThat(out.toString()).contains("숫자 야구 게임을 시작합니다.");
    }

    @DisplayName("입력된 숫자에 대한 결과 출력")
    @ParameterizedTest
    @CsvSource(value = {"1,1,1볼 1스트라이크","1,0,1볼","0,1,1스트라이크","0,0,낫싱"})
    void printResult(Integer ballCount, Integer strikeCount, String result){
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        OutputView outputView = new OutputView();

        outputView.printResult(ballCount, strikeCount);

        assertThat(out.toString()).contains(result);
    }

    @DisplayName("3스트라이크 경우 게임 종료문구 출력")
    @Test
    void printExit(){
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        OutputView outputView = new OutputView();

        outputView.printExit();

        assertThat(out.toString()).contains("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
