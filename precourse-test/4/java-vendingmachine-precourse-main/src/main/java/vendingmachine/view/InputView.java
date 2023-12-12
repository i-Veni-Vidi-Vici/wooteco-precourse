package vendingmachine.view;

import static vendingmachine.constants.Message.HAVING_MONEY_INPUT;
import static vendingmachine.constants.Message.MONEY_INPUT;
import static vendingmachine.constants.Message.PRODUCT_INPUT;
import static vendingmachine.constants.Message.PURCHASE_INPUT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getHavingMoney() {
        System.out.println(HAVING_MONEY_INPUT.getMessage());
        return Console.readLine();
    }

    public String getProduct() {
        System.out.println();
        System.out.println(PRODUCT_INPUT.getMessage());
        return Console.readLine();
    }

    public String getMoney() {
        System.out.println();
        System.out.println(MONEY_INPUT.getMessage());
        return Console.readLine();
    }

    public String getPurchase() {
        System.out.println(PURCHASE_INPUT.getMessage());
        return Console.readLine();
    }
}
