package vendingmachine;

import vendingmachine.domain.Change;
import vendingmachine.domain.Products;
import vendingmachine.domain.User;
import vendingmachine.utility.Converter;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachine {
    private final InputView inputView;
    private final OutputView outputView;
    private final Converter converter;

    public VendingMachine() {
        inputView = new InputView();
        outputView = new OutputView();
        converter = new Converter();
    }

    void run() {
        Change change = setMoney();

        outputView.printCoin(change.getCoins());

        Products products = setProduct();
        User user = putMoney();
        outputView.printMoney(user.getMoney());

        purchase(user, products);
        outputView.printChange(change.give(user.getMoney()));
    }

    private Change setMoney() {
        boolean isSetting = true;
        Change change = null;

        while (isSetting) {
            try {
                change = new Change(converter.convertToNumber(inputView.getHavingMoney()));
                isSetting = false;
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }

        return change;
    }

    private Products setProduct() {
        boolean isSetting = true;
        Products products = null;

        while (isSetting) {
            try {
                products = new Products(converter.convertToMap(inputView.getProduct()));
                isSetting = false;
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }

        return products;
    }

    private User putMoney() {
        boolean isPutting = true;
        User user = null;

        while (isPutting) {
            try {
                user = new User(converter.convertToNumber(inputView.getMoney()));
                isPutting = false;
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }

        return user;
    }


    private void purchase(User user, Products products) {
        while (products.isExistence() && products.canPurchase(user.getMoney())) {
            try {
                user.pay(products.sell(inputView.getPurchase(), user.getMoney()));
                outputView.printMoney(user.getMoney());
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }
    }
}
