package bridge.view;

import java.util.List;

public class OutputView {
    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printMap(List<List<String>> result) {
        printOneMap(result, "U");
        printOneMap(result, "D");
    }

    private void printOneMap(List<List<String>> result, String direction) {
        StringBuilder oneMap = new StringBuilder("[");

        for (List<String> stage : result) {
            if (oneMap.length() > 1) {
                oneMap.append("|");
            }

            oneMap.append(expressMap(stage, direction));
        }

        oneMap.append("]");
        System.out.println(oneMap);
    }

    private String expressMap(List<String> stage, String direction) {
        if (stage.get(0).equals(direction)) {
            return (" " + stage.get(1) + " ");

        }

        return (" " + " " + " ");
    }

    public void printResult(List<List<String>> result, Integer retryCount) {
        System.out.println("최종 게임 결과");
        printMap(result);

        System.out.println("게임 성공 여부: " + calculateResult(result));
        System.out.println("총 시도한 횟수: " + retryCount);
    }

    private String calculateResult(List<List<String>> result) {
        for (List<String> stage : result) {
            if (stage.contains("X")) {
                return "실패";
            }
        }

        return "성공";
    }

    public void printError(String error) {
        System.out.println(error);
    }
}
