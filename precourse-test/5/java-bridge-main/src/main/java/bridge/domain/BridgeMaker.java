package bridge.domain;

import static bridge.constants.Error.RANGE_ERROR;
import static bridge.constants.Message.BELOW_BRIDGE;
import static bridge.constants.Message.UPPER_BRIDGE;
import static bridge.constants.Value.INITIAL_ZERO;
import static bridge.constants.Value.MAX_LENGTH;
import static bridge.constants.Value.MIN_LENGTH;
import static bridge.constants.Value.ZERO;

import bridge.utility.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        check(size);
        List<String> bridge = new ArrayList<>();

        for (int count = INITIAL_ZERO.get(); count < size; count++) {
            bridge.add(selectBridge());
        }

        return bridge;
    }

    private String selectBridge() {
        if (bridgeNumberGenerator.generate() == ZERO.get()) {
            return BELOW_BRIDGE.getMessage();
        }
        return UPPER_BRIDGE.getMessage();
    }

    private void check(int size) {
        if ((size < MIN_LENGTH.get()) || (size > MAX_LENGTH.get())) {
            throw new IllegalArgumentException(RANGE_ERROR.getMessage());
        }
    }
}
