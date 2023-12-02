package menu.view;


import java.util.List;
import java.util.Map;

public class OutputView {
    public void printError(String error) {
        System.out.println(error);
    }

    public void printStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printRecommendations(List<String> categories, Map<String, List<String>> recommendations) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");

        System.out.print("[ 카테고리 | ");
        System.out.print(String.join(" " + "|" + " ", categories));
        System.out.println(" " + "]");

        for (String coach : recommendations.keySet()) {
            System.out.print("[" + " " + coach + " " + "|" + " ");

            System.out.print(String.join(" " + "|" + " ", recommendations.get(coach)));
            System.out.println(" " + "]");
        }
    }

    public void printCompletion() {
        System.out.println("추천을 완료했습니다.");
    }
}
