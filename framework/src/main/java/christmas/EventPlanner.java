package christmas;

import static christmas.constants.Condition.FALSE;
import static christmas.constants.Condition.TRUE;

import christmas.utility.Converter;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlanner {
    private final InputView inputView;
    private final OutputView outputView;
    private final Converter converter;

    public EventPlanner() {
        inputView = new InputView();
        outputView = new OutputView();
        converter = new Converter();
    }

    void run() {


    }

    private ReservedDate reserveDate() {
        boolean isReserving = TRUE.get();
        ReservedDate reservedDate = null;

        while (isReserving) {
            try {
                reservedDate = new ReservedDate(converter.convertToNumber(inputView.getDate()));
                isReserving = FALSE.get();
            } catch (IllegalArgumentException exception) {
                outputView.printError("[ERROR]");
            }
        }

        return reservedDate;
    }
}
