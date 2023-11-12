package christmas;

import christmas.domain.ReservedDate;
import christmas.domain.ReservedMenu;
import christmas.utility.Converter;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlanner {

    public void run(){
        OutputView.printPlanner();
        reserveDate();
        reserveMenu();
    }

    public void reserveDate() {
        boolean isReserving = true;
        while (isReserving) {
            try {
                ReservedDate reservedDate = new ReservedDate(Converter.convertToNumber(InputView.getDate()));
                isReserving = false;
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
    }

    public void reserveMenu() {
        boolean isReserving = true;

        while (isReserving) {
            try {
                ReservedMenu reservedMenu = new ReservedMenu(Converter.convertToReservedMenu(InputView.getMenu()));
                isReserving = false;
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }
}
