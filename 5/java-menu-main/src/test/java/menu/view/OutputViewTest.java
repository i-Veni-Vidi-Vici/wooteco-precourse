package menu.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

    private static OutputView outputView;
    private static OutputStream out;

    @BeforeAll
    static void beforeAll() {
        outputView = new OutputView();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @DisplayName("점심 메뉴 추천 시작 문구 출력")
    @Test
    void printStart() {
        outputView.printStart();

        assertThat(out.toString())
                .contains("점심 메뉴 추천을 시작합니다.");
    }

    @DisplayName("메뉴 추천 결과 출력")
    @Test
    void printRecommendations() {
        outputView.printRecommendations(List.of("한식", "한식", "일식", "중식", "아시안"), Map.of(
                "토미", List.of("쌈밥", "김치찌개", "미소시루", "짜장면", "팟타이"),
                "제임스", List.of("된장찌개", "비빔밥", "가츠동", "토마토 달걀볶음", "파인애플 볶음밥"),
                "포코", List.of("된장찌개", "불고기", "하이라이스", "탕수육", "나시고렝")
        ));

        assertThat(out.toString())
                .contains("메뉴 추천 결과입니다.")
                .contains("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]")
                .contains("[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]")
                .contains("[ 토미 | 쌈밥 | 김치찌개 | 미소시루 | 짜장면 | 팟타이 ]")
                .contains("[ 제임스 | 된장찌개 | 비빔밥 | 가츠동 | 토마토 달걀볶음 | 파인애플 볶음밥 ]")
                .contains("[ 포코 | 된장찌개 | 불고기 | 하이라이스 | 탕수육 | 나시고렝 ]");
    }

    @DisplayName("추천 완료 문구 출력")
    @Test
    void printCompletion() {
        outputView.printCompletion();

        assertThat(out.toString())
                .contains("추천을 완료했습니다.");
    }

    @DisplayName("에러 메시지 출력")
    @Test
    void printError() {
        outputView.printError("[ERROR] 코치 이름 길이는 2~4자 이어야 입니다.");

        assertThat(out.toString())
                .contains("[ERROR] 코치 이름 길이는 2~4자 이어야 입니다.");
    }
}
