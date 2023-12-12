package vendingmachine.domain;

import static vendingmachine.constants.Error.DEFICIENT_MONEY_ERROR;
import static vendingmachine.constants.Error.MIN_PRICE_ERROR;
import static vendingmachine.constants.Error.MIN_PRICE_UNIT_ERROR;
import static vendingmachine.constants.Error.PRODUCT_COUNT_ERROR;
import static vendingmachine.constants.Error.PRODUCT_NONEXISTENT_ERROR;
import static vendingmachine.constants.Error.SOLD_OUT_ERROR;
import static vendingmachine.constants.Value.FIRST_INDEX;
import static vendingmachine.constants.Value.INITIAL_ZERO;
import static vendingmachine.constants.Value.MIN_PRICE;
import static vendingmachine.constants.Value.MON_PRICE_UNIT;
import static vendingmachine.constants.Value.ONE;
import static vendingmachine.constants.Value.PRODUCT_COUNT_ZERO;
import static vendingmachine.constants.Value.REMAINDER_ZERO;
import static vendingmachine.constants.Value.SECOND_INDEX;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Products {
    private final Map<String, List<Integer>> products;

    public Products(Map<String, List<Integer>> products) {
        checkPrice(products);
        checkRemainder(products);
        checkCount(products);
        this.products = products;
    }

    private void checkPrice(Map<String, List<Integer>> products) {
        for (String product : products.keySet()) {
            if (products.get(product).get(FIRST_INDEX.get()) < MIN_PRICE.get()) {
                throw new IllegalArgumentException(MIN_PRICE_ERROR.getMessage());
            }
        }
    }

    private void checkRemainder(Map<String, List<Integer>> products) {
        for (String product : products.keySet()) {
            if ((products.get(product).get(FIRST_INDEX.get()) % MON_PRICE_UNIT.get()) != REMAINDER_ZERO.get()) {
                throw new IllegalArgumentException(MIN_PRICE_UNIT_ERROR.getMessage());
            }
        }
    }

    private void checkCount(Map<String, List<Integer>> products) {
        for (String product : products.keySet()) {
            if (products.get(product).get(SECOND_INDEX.get()).equals(PRODUCT_COUNT_ZERO.get())) {
                throw new IllegalArgumentException(PRODUCT_COUNT_ERROR.getMessage());
            }
        }
    }

    public boolean isExistence() {
        Integer count = INITIAL_ZERO.get();

        for (String product : products.keySet()) {
            count += products.get(product).get(1);
        }

        return !count.equals(PRODUCT_COUNT_ZERO.get());
    }

    public boolean canPurchase(Integer money) {
        for (String product : products.keySet()) {
            if (products.get(product).get(FIRST_INDEX.get()) <= money) {
                return true;
            }
        }

        return false;
    }

    public Integer sell(String product, Integer money) {
        checkProduct(product);
        checkCount(product);
        checkMoney(product, money);
        products.get(product).set(SECOND_INDEX.get(), products.get(product).get(SECOND_INDEX.get()) - ONE.get());
        return products.get(product).get(FIRST_INDEX.get());
    }

    private void checkProduct(String product) {
        if (!products.containsKey(product)) {
            throw new IllegalArgumentException(PRODUCT_NONEXISTENT_ERROR.getMessage());
        }
    }

    private void checkMoney(String product, Integer money) {
        if (money < products.get(product).get(FIRST_INDEX.get())) {
            throw new IllegalArgumentException(DEFICIENT_MONEY_ERROR.getMessage());
        }
    }

    private void checkCount(String product) {
        if (products.get(product).get(SECOND_INDEX.get()) == PRODUCT_COUNT_ZERO.get()) {
            throw new IllegalArgumentException(SOLD_OUT_ERROR.getMessage());
        }
    }

    public Map<String, List<Integer>> get() {
        return Collections.unmodifiableMap(products);
    }
}
