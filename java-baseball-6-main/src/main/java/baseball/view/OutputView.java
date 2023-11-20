package baseball.view;

public class OutputView {

    public void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printResult(Integer ballCount, Integer strikeCount) {
        if (ballCount > 0) {
            System.out.print(ballCount + "볼 ");
        }
        if (strikeCount > 0) {
            System.out.print(strikeCount + "스트라이크");
        }
        if ((ballCount + strikeCount) == 0) {
            System.out.print("낫싱");
        }

        System.out.println();
    }

    public void printExit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
