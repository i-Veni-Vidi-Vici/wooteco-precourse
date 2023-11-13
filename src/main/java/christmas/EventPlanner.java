package christmas;

import christmas.constants.Badge;
import christmas.domain.promotion.Benefits;
import christmas.domain.ReservedDate;
import christmas.domain.ReservedMenu;
import christmas.domain.promotion.giveaway.Champagne;
import christmas.utility.Converter;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlanner {
    private ReservedDate reservedDate;
    private ReservedMenu reservedMenu;

    private Benefits benefits;

    public void run(){
        OutputView.printPlanner();
        reserveDate();
        reserveMenu();
        benefits = new Benefits(reservedDate.getDate(), reservedMenu);
        Integer totalAmount = reservedMenu.calculateTotalAmount();
        Integer totalDiscount = benefits.calculateTotalDiscount(reservedDate.getDate(),totalAmount,reservedMenu);
        OutputView.printDate(reservedDate.getDate());
        OutputView.printMenu(reservedMenu.getMenu());
        OutputView.printTotalAmount(totalAmount);
        OutputView.printFreeGift(Champagne.checkChampagne(totalAmount));
        OutputView.printBenefitDetails(benefits.getBenefits());
        OutputView.printTotalBenefitAmount(totalDiscount);
        OutputView.printPaymentAmount(benefits.discount(totalAmount, totalDiscount));
        OutputView.printBadge(Badge.grant(totalDiscount));
    }

    public void reserveDate() {
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

    public void reserveMenu() {
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
}
