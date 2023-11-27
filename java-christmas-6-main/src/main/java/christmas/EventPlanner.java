package christmas;

import christmas.constants.Badge;
import christmas.domain.Benefits;
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
        Benefits benefits = new Benefits();
        outputView.printGiveaway(benefits.checkGiveaway(reservedMenu.calculateAmount()));
        outputView.printBenefits(benefits.create(reservedDate, reservedMenu));

        Integer benefitAmount = benefits.calculateBenefitAmount(reservedDate, reservedMenu);
        outputView.printBenefitAmount(benefitAmount);
        outputView.printPaymentAmount(benefits.calculatePaymentAmount(reservedDate, reservedMenu));
        outputView.printBadge(Badge.grant(benefitAmount));
    }


    private ReservedDate reserveDate() {
        boolean isReserving = true;
        ReservedDate reservedDate = null;

        while (isReserving) {
            try {
                reservedDate = new ReservedDate(converter.convertToNumber(inputView.getDate()));
                isReserving = false;
            } catch (IllegalArgumentException exception) {
                outputView.printError("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }

        return reservedDate;
    }

    private ReservedMenu reserveMenu() {
        boolean isReserving = true;
        ReservedMenu reservedMenu = null;

        while (isReserving) {
            try {
                reservedMenu = new ReservedMenu(converter.convertToMap(inputView.getMenu()));
                isReserving = false;
            } catch (IllegalArgumentException exception) {
                outputView.printError("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }

        return reservedMenu;
    }
}
