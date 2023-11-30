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

    public void move(List<String> bridge, String direction) {
        checkMove(direction);

        if (bridge.get(result.size()).equals(direction)) {
            result.add(List.of(direction, "O"));
            return;
        }

        result.add(List.of(direction, "X"));
    }

    private void checkMove(String direction) {
        if (!direction.equals("U") && !direction.equals("D")) {
            throw new IllegalArgumentException();
        }
    }


    public boolean retry(String retryValue) {
        checkRetry(retryValue);
        countRetry(retryValue);

        return retryValue.equals("R");
    }

    private void countRetry(String retryValue) {
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
