package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<List<String>> result;



    private Integer retryCount;

    public BridgeGame() {
        retryCount = 1;
        result = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(List<String> bridge, String direction) {
        checkMove(direction);

        if (bridge.get(result.size()).equals(direction)) {
            result.add(List.of(direction, "O"));
        }

        if (!bridge.get(result.size()).equals(direction)) {
            result.add(List.of(direction, "X"));
        }
    }

    private void checkMove(String direction) {
        if (!direction.equals("U") && !direction.equals("D")) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String retryValue) {
        checkRetry(retryValue);
        countRetry(retryValue);

        return retryValue.equals("R");
    }

    private void countRetry(String retryValue){
        if (retryValue.equals("R")) {
            retryCount++;
        }
    }

    private void checkRetry(String retryValue) {
        if ((!retryValue.equals("R")) && (!retryValue.equals("Q"))) {
            throw new IllegalArgumentException();
        }
    }

    public Integer getRetryCount() {
        return retryCount;
    }

    public List<List<String>> getResult() {
        return Collections.unmodifiableList(result);
    }
}
