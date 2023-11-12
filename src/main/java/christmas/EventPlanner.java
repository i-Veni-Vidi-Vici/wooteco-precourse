package christmas;

import christmas.domain.ReservedDate;
import christmas.utility.Converter;
import christmas.view.InputView;

public class EventPlanner {


    public void reserveDate() {
        boolean isReserving = true;

        while (isReserving) {
            try {
                ReservedDate reservedDate = new ReservedDate(Converter.convertToNumber(InputView.getDate()));
                isReserving = false;
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }




}
