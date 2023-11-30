package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.utility.BridgeRandomNumberGenerator;
import bridge.utility.Converter;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class GameManager {
    private final InputView inputView;
    private final OutputView outputView;
    private final Converter converter;

    public GameManager() {
        inputView = new InputView();
        outputView = new OutputView();
        converter = new Converter();
    }

    void run() {
        outputView.printStart();
        BridgeGame bridgeGame = new BridgeGame();

        startGame(bridgeGame, makeBridge());
        outputView.printResult(bridgeGame.getResult(), bridgeGame.getRetryCount());
    }

    private void startGame(BridgeGame bridgeGame, List<String> bridge) {
        boolean isRunning = true;
        while (bridge.size() != bridgeGame.getResult().size() && isRunning) {
            crossBridge(bridge, bridgeGame);
            outputView.printMap(bridgeGame.getResult());
            isRunning = isRunning(bridgeGame);
        }
    }

    private boolean isRunning(BridgeGame bridgeGame) {
        boolean isRunning = true;

        for (List<String> stage : bridgeGame.getResult()) {
            if (stage.contains("X")) {
                isRunning = retry(bridgeGame);
                initialize(isRunning, bridgeGame);
                break;
            }
        }

        return isRunning;
    }

    private void initialize(boolean isRunning, BridgeGame bridgeGame) {
        if (isRunning) {
            bridgeGame = new BridgeGame();
        }
    }

    private boolean retry(BridgeGame bridgeGame) {
        boolean isSelecting = true;
        boolean isRetry = false;

        while (isSelecting) {
            try {
                isRetry = bridgeGame.retry(inputView.getRetry());
                isSelecting = false;
            } catch (IllegalArgumentException exception) {
                outputView.printError("[ERROR]");
            }
        }

        return isRetry;
    }

    private List<String> makeBridge() {
        boolean isMaking = true;
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = null;

        while (isMaking) {
            try {
                bridge = bridgeMaker.makeBridge(converter.convertToNumber(inputView.getBridgeLength()));
                isMaking = false;
            } catch (IllegalArgumentException exception) {
                outputView.printError("[ERROR]");
            }
        }

        return bridge;
    }

    private void crossBridge(List<String> bridge, BridgeGame bridgeGame) {
        boolean isCrossing = true;

        while (isCrossing) {
            try {
                bridgeGame.move(bridge, inputView.getDirection());
                isCrossing = false;
            } catch (IllegalArgumentException exception) {
                outputView.printError("[ERROR]");
            }
        }
    }
}
