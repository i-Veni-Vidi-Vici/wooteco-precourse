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
import java.util.Objects;

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

        startGame(bridgeGame, Objects.requireNonNull(makeBridge(new BridgeMaker(new BridgeRandomNumberGenerator()))));
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
        for (List<String> stage : bridgeGame.getResult()) {
            if (stage.contains(WRONG.getMessage())) {
                return retry(bridgeGame);
            }
        }

        return TRUE.get();
    }

    private boolean retry(BridgeGame bridgeGame) {
        boolean isRetry = isRetry(bridgeGame);
        if (isRetry) {
            bridgeGame.initialize();
        }

        return isRetry;
    }


    private boolean isRetry(BridgeGame bridgeGame) {
        while (TRUE.get()) {
            try {
                return bridgeGame.retry(inputView.getRetry());
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }

        return FALSE.get();
    }

    private List<String> makeBridge(BridgeMaker bridgeMaker) {
        while (TRUE.get()) {
            try {
                return bridgeMaker.makeBridge(converter.convertToNumber(inputView.getBridgeLength()));
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }

        return null;
    }

    private void crossBridge(List<String> bridge, BridgeGame bridgeGame) {
        while (TRUE.get()) {
            try {
                bridgeGame.move(bridge, inputView.getDirection());
                return;
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }
    }
}
