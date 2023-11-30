package bridge;

import static bridge.constants.Condition.FALSE;
import static bridge.constants.Condition.TRUE;
import static bridge.constants.Message.WRONG;

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
        boolean isRunning = TRUE.get();
        while (bridge.size() != bridgeGame.getResult().size() && isRunning) {
            crossBridge(bridge, bridgeGame);
            outputView.printMap(bridgeGame.getResult());
            isRunning = isRunning(bridgeGame);
        }
    }

    private boolean isRunning(BridgeGame bridgeGame) {
        boolean isRunning = TRUE.get();

        for (List<String> stage : bridgeGame.getResult()) {
            if (stage.contains(WRONG.getMessage())) {
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
        boolean isSelecting = TRUE.get();
        boolean isRetry = FALSE.get();

        while (isSelecting) {
            try {
                isRetry = bridgeGame.retry(inputView.getRetry());
                isSelecting = FALSE.get();
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }

        return isRetry;
    }

    private List<String> makeBridge() {
        boolean isMaking = TRUE.get();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = null;

        while (isMaking) {
            try {
                bridge = bridgeMaker.makeBridge(converter.convertToNumber(inputView.getBridgeLength()));
                isMaking = FALSE.get();
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }

        return bridge;
    }

    private void crossBridge(List<String> bridge, BridgeGame bridgeGame) {
        boolean isCrossing = TRUE.get();

        while (isCrossing) {
            try {
                bridgeGame.move(bridge, inputView.getDirection());
                isCrossing = FALSE.get();
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }
    }
}
