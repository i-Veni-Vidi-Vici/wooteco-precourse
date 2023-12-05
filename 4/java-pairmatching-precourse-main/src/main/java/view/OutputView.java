package view;

import java.util.List;

public class OutputView {

    public void printError(String error) {
        System.out.println(error);
    }

    public void printInformation() {
        System.out.println("#############################################");
        System.out.println("과정: 백엔드 | 프론트엔드");
        System.out.println("미션:");
        System.out.println("  - 레벨1: 자동차경주 | 로또 | 숫자야구게임");
        System.out.println("  - 레벨2: 장바구니 | 결제 | 지하철노선도");
        System.out.println("  - 레벨3: ");
        System.out.println("  - 레벨4: 성능개선 | 배포");
        System.out.println("  - 레벨5: ");
        System.out.println("  - 레벨5: ");
        System.out.println("#############################################");
    }

    public void printResult(List<String> crews) {
        System.out.println("페어 매칭 결과입니다.");

        if (crews.size() % 2 == 0) {
            printEvenCrews(crews);
        }
        if (crews.size() % 2 == 1) {
            printOddCrews(crews);
        }
    }

    private void printEvenCrews(List<String> crews){
        for (int index = 0; index < crews.size(); index += 2) {
            System.out.println(crews.get(index) + " : " + crews.get(index + 1));
        }
    }

    private void printOddCrews(List<String> crews){
        for (int index = 0; index < crews.size(); index += 2) {
            if (index == crews.size() - 3) {
                System.out.println(crews.get(index) + " : " + crews.get(index + 1) + " : " + crews.get(index + 2));
                return;
            }
            System.out.println(crews.get(index) + " : " + crews.get(index + 1));
        }
    }

    public void printInitialization() {
        System.out.println("초기화 되었습니다.");
    }
}
