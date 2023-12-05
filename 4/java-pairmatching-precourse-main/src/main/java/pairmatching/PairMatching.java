package pairmatching;

import static pairmatching.constants.Condition.FALSE;
import static pairmatching.constants.Condition.TRUE;
import static pairmatching.constants.FunctionValue.FAIR_INITIALIZATION;
import static pairmatching.constants.FunctionValue.FAIR_MATCHING;
import static pairmatching.constants.FunctionValue.FAIR_SEARCH;
import static pairmatching.constants.FunctionValue.QUIT;
import static pairmatching.constants.Symbol.EMPTY;

import java.util.Objects;
import pairmatching.constants.Choice;
import pairmatching.domain.Crew;
import pairmatching.domain.Function;
import pairmatching.domain.Information;
import view.InputView;
import view.OutputView;

public class PairMatching {
    private final InputView inputView;
    private final OutputView outputView;

    public PairMatching() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    void run() {
        String function = EMPTY.get();
        Crew crew = new Crew();
        runFunction(function, crew);
    }

    private void runFunction(String function, Crew crew) {
        while (!function.equals(QUIT.get())) {
            function = selectFunction();

            if (function.equals(FAIR_MATCHING.get())) {
                outputView.printInformation();
                matchPair(crew);
            }
            if (function.equals(FAIR_SEARCH.get())) {
                searchPair(crew);
            }
            if (function.equals(FAIR_INITIALIZATION.get())) {
                initializePair(crew);
            }
        }
    }

    private void matchPair(Crew crew) {
        String information = selectInformation();

        if (crew.checkMatching(information)) {
            choice(crew, information);
        }
        if (!crew.checkMatching(information)) {
            outputView.printResult(crew.match(information));
        }
    }

    private void choice(Crew crew, String information) {
        boolean choice = selectChoice();

        if (choice) {
            outputView.printResult(crew.match(information));
        }
        if (!choice) {
            matchPair(crew);
        }
    }

    private void searchPair(Crew crew) {
        outputView.printInformation();
        outputView.printResult(crew.search(selectInformation()));
    }

    private void initializePair(Crew crew) {
        crew.initialize();
        outputView.printInitialization();
    }

    private String selectFunction() {
        boolean isSelecting = TRUE.get();
        Function function = null;

        while (isSelecting) {
            try {
                function = new Function(inputView.getFunction());
                isSelecting = FALSE.get();
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }

        return Objects.requireNonNull(function).get();
    }

    private String selectInformation() {
        boolean isSelecting = TRUE.get();
        Information information = null;

        while (isSelecting) {
            try {
                information = new Information(inputView.getInformation());
                isSelecting = FALSE.get();
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }

        return Objects.requireNonNull(information).get();
    }

    private boolean selectChoice() {
        boolean isSelecting = TRUE.get();
        boolean choice = FALSE.get();

        while (isSelecting) {
            try {
                choice = Choice.checkExistence(inputView.getNewMatching());
                isSelecting = FALSE.get();
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }

        return choice;
    }
}


