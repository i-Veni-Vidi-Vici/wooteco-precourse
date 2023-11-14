package christmas;

import static christmas.constants.Condition.FALSE;
import static christmas.constants.Condition.TRUE;
import static christmas.constants.Error.INVALID_DATE_ERROR;
import static christmas.constants.Error.INVALID_ORDER_ERROR;

import christmas.constants.Badge;
import christmas.domain.MenuOption;
import christmas.domain.promotion.Benefits;
import christmas.domain.ReservedDate;
import christmas.domain.ReservedMenu;
import christmas.utility.Converter;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlanner {
    private ReservedDate reservedDate;
    private ReservedMenu reservedMenu;
    private Benefits benefits;
    private final OutputView outputView;
    private final InputView inputView;

    public EventPlanner() {
        outputView = new OutputView();
        inputView = new InputView();
    }

    public void run() {
        showPlanner();

        reserveDate();
        selectMenuOption();
        reserveMenu();

        benefits = new Benefits(reservedDate.getDate(), reservedMenu);

        showReservation();
        showBenefits(benefits.calculateTotalBenefit());
    }

    private void showPlanner() {
        outputView.printPlanner();
    }

    private void reserveDate() {
        boolean isReserving = TRUE.get();

        while (isReserving) {
            try {
                reservedDate = new ReservedDate(Converter.convertToNumber(inputView.getDate()));
                isReserving = FALSE.get();
            } catch (IllegalArgumentException ex) {
                outputView.printError(INVALID_DATE_ERROR.getMessage());
            }
        }
    }

    private void reserveMenu() {
        boolean isReserving = TRUE.get();

        while (isReserving) {
            try {
                reservedMenu = new ReservedMenu(Converter.convertToReservedMenu(inputView.getMenu()));
                isReserving = FALSE.get();
            } catch (IllegalArgumentException ex) {
                outputView.printError(INVALID_ORDER_ERROR.getMessage());
            }
        }
    }

    private void selectMenuOption() {
        boolean isReserving = TRUE.get();

        while (isReserving) {
            try {
                MenuOption menuOption = new MenuOption(Converter.convertToNumber(inputView.getMenuOption()));
                outputView.printAllMenu(menuOption.isOption());
                isReserving = FALSE.get();
            } catch (IllegalArgumentException ex) {
                outputView.printError("[ERROR] 숫자 1 또는 2를 입력해 주세요.");
            }
        }
    }

    private void showReservation() {
        outputView.printDate(reservedDate.getDate());
        outputView.printMenu(reservedMenu.getMenu());
        outputView.printTotalAmount(reservedMenu.calculateTotalAmount());
    }

    private void showBenefits(Integer totalDiscount) {
        outputView.printGiveaway(benefits.checkGiveaway());
        outputView.printBenefitDetails(benefits.getBenefits());
        outputView.printTotalBenefitAmount(totalDiscount);
        outputView.printPaymentAmount(benefits.discount());
        outputView.printBadge(Badge.grant(totalDiscount));
    }
}
