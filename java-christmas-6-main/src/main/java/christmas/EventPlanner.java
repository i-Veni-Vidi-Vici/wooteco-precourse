package christmas;

import static christmas.constants.Condition.FALSE;
import static christmas.constants.Condition.TRUE;
import static christmas.constants.Error.INVALID_DATE_ERROR;
import static christmas.constants.Error.INVALID_MENU_ERROR;

import christmas.constants.Badge;
import christmas.domain.promotion.Benefits;
import christmas.domain.ReservedDate;
import christmas.domain.ReservedMenu;
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
        outputView.printPlanner();
        ReservedDate reservedDate = reserveDate();
        ReservedMenu reservedMenu = reserveMenu();

        printReservation(reservedDate, reservedMenu);
        printBenefits(reservedDate, reservedMenu);
    }

    private void printReservation(ReservedDate reservedDate, ReservedMenu reservedMenu) {
        outputView.printDate(reservedDate.get());
        outputView.printMenu(reservedMenu.get());
        outputView.printAmount(reservedMenu.calculateAmount());
    }


    private void printBenefits(ReservedDate reservedDate, ReservedMenu reservedMenu) {
        Benefits benefits = new Benefits(reservedDate, reservedMenu);
        outputView.printGiveaway(benefits.checkGiveaway());
        outputView.printBenefits(benefits.get());

        Integer benefitAmount = benefits.calculateBenefitAmount();
        outputView.printBenefitAmount(benefitAmount);
        outputView.printPaymentAmount(benefits.calculatePaymentAmount());
        outputView.printBadge(Badge.grant(benefitAmount));
    }

    private ReservedDate reserveDate() {
        boolean isReserving = TRUE.get();
        ReservedDate reservedDate = null;

        while (isReserving) {
            try {
                reservedDate = new ReservedDate(converter.convertToNumber(inputView.getDate()));
                isReserving = FALSE.get();
            } catch (IllegalArgumentException exception) {
                outputView.printError(INVALID_DATE_ERROR.getMessage());
            }
        }

        return reservedDate;
    }

    private ReservedMenu reserveMenu() {
        boolean isReserving = TRUE.get();
        ReservedMenu reservedMenu = null;

        while (isReserving) {
            try {
                reservedMenu = new ReservedMenu(converter.convertToMap(inputView.getMenu()));
                isReserving = FALSE.get();
            } catch (IllegalArgumentException exception) {
                outputView.printError(INVALID_MENU_ERROR.getMessage());
            }
        }

        return reservedMenu;
    }
}
