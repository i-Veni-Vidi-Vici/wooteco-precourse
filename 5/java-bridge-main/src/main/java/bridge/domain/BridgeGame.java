package bridge.domain;

import static bridge.constants.Error.INVALID_MOVE_ERROR;
import static bridge.constants.Error.INVALID_RETRY_ERROR;
import static bridge.constants.Message.BELOW_BRIDGE;
import static bridge.constants.Message.EXIT;
import static bridge.constants.Message.WRONG;
import static bridge.constants.Message.RETRY;
import static bridge.constants.Message.RIGHT;
import static bridge.constants.Message.UPPER_BRIDGE;
import static bridge.constants.Value.INITIAL_ONE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeGame {

    private final List<List<String>> result;

    private Integer retryCount;

    public BridgeGame() {
        retryCount = INITIAL_ONE.get();
        result = new ArrayList<>();
    }

    public void move(List<String> bridge, String direction) {
        checkMove(direction);

        if (bridge.get(result.size()).equals(direction)) {
            result.add(List.of(direction, RIGHT.getMessage()));
            return;
        }

        result.add(List.of(direction, WRONG.getMessage()));
    }

    private void checkMove(String direction) {
        if (!direction.equals(UPPER_BRIDGE.getMessage()) && !direction.equals(BELOW_BRIDGE.getMessage())) {
            throw new IllegalArgumentException(INVALID_MOVE_ERROR.getMessage());
        }
    }

    public boolean retry(String retryValue) {
        checkRetry(retryValue);
        countRetry(retryValue);

        return retryValue.equals(RETRY.getMessage());
    }

    private void countRetry(String retryValue) {
        if (retryValue.equals(RETRY.getMessage())) {
            retryCount++;
        }
    }

    private void checkRetry(String retryValue) {
        if ((!retryValue.equals(RETRY.getMessage())) && (!retryValue.equals(EXIT.getMessage()))) {
            throw new IllegalArgumentException(INVALID_RETRY_ERROR.getMessage());
        }
    }

    public Integer getRetryCount() {
        return retryCount;
    }

    public void initialize(){
        result.clear();
    }

    public List<List<String>> getResult() {
        return Collections.unmodifiableList(result);
    }
}
