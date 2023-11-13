package christmas;

import christmas.constants.Badge;
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

    public void run() {
        showPlanner();

        reserveDate();
        reserveMenu();

        benefits = new Benefits(reservedDate.getDate(), reservedMenu);

        showReservation();
        showBenefits(benefits.calculateTotalBenefit());
    }

    private void showPlanner() {
        OutputView.printPlanner();
    }

    private void reserveDate() {
        boolean isReserving = true;
        while (isReserving) {
            try {
                reservedDate = new ReservedDate(Converter.convertToNumber(InputView.getDate()));
                isReserving = false;
            } catch (IllegalArgumentException ex) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
    }

    private void reserveMenu() {
        boolean isReserving = true;

        while (isReserving) {
            try {
                reservedMenu = new ReservedMenu(Converter.convertToReservedMenu(InputView.getMenu()));
                isReserving = false;
            } catch (IllegalArgumentException ex) {
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    private void showReservation() {
        OutputView.printDate(reservedDate.getDate());
        OutputView.printMenu(reservedMenu.getMenu());
        OutputView.printTotalAmount(reservedMenu.calculateTotalAmount());
    }

    private void showBenefits(Integer totalDiscount) {
        OutputView.printFreeGift(benefits.checkGiveaway());
        OutputView.printBenefitDetails(benefits.getBenefits());
        OutputView.printTotalBenefitAmount(totalDiscount);
        OutputView.printPaymentAmount(benefits.discount());
        OutputView.printBadge(Badge.grant(totalDiscount));
    }

}
