package pairmatching;

import java.util.List;
import pairmatching.constants.Choice;
import pairmatching.domain.Crew;
import pairmatching.domain.Function;
import pairmatching.domain.Information;
import pairmatching.utility.Converter;
import view.InputView;
import view.OutputView;

public class PairMatching {
    private final InputView inputView;
    private final OutputView outputView;
    private final Converter converter;

    public PairMatching() {
        inputView = new InputView();
        outputView = new OutputView();
        converter = new Converter();
    }

    void run() {
        String function = "";
        Crew crew = new Crew();

        runFunction(function, crew);
    }

    private void runFunction(String function, Crew crew) {
        while (!function.equals("Q")) {
            function = selectFunction();

            if (function.equals("1")) {
                outputView.printInformation();
                matchPair(crew);
            }
            if (function.equals("2")) {
                searchPair(crew);
            }
            if (function.equals("3")) {
                initializePair(crew);
            }
        }
    }

    private void initializePair(Crew crew) {
        crew.initialize();
        outputView.printInitialization();
    }

    private void searchPair(Crew crew) {
        outputView.printInformation();
        outputView.printResult(crew.search(selectInformation()));
    }

    private void matchPair(Crew crew) {
        String information = selectInformation();

        if (crew.checkMatching(information)) {
            boolean choice = selectChoice();
            if (choice) {
                outputView.printResult(crew.match(information));
            }
            if (!choice) {
                matchPair(crew);
            }
        }
        if (!crew.checkMatching(information)) {
            outputView.printResult(crew.match(information));
        }
    }

    private String selectFunction() {
        boolean isSelecting = true;
        Function function = null;

        while (isSelecting) {
            try {
                function = new Function(inputView.getFunction());
                isSelecting = false;
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }

        return function.get();
    }

    private String selectInformation() {
        boolean isSelecting = true;
        Information information = null;

        while (isSelecting) {
            try {
                information = new Information(inputView.getInformation());
                isSelecting = false;
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }

        return information.get();
    }

    private boolean selectChoice() {
        boolean isSelecting = true;
        boolean choice = false;

        while (isSelecting) {
            try {
                choice = Choice.checkExistence(inputView.getNewMatching());
                isSelecting = false;
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }

        return choice;
    }
}


