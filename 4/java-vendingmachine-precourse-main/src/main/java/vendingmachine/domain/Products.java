package vendingmachine.domain;

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
            if (products.get(product).get(0) < 100) {
                throw new IllegalArgumentException("[ERROR] 상품 가격은 100원 이상 이어야 합니다.");
            }
        }
    }

    private void checkRemainder(Map<String, List<Integer>> products) {
        for (String product : products.keySet()) {
            if ((products.get(product).get(0) % 10) != 0) {
                throw new IllegalArgumentException("[ERROR] 상품 가격은 10원 단위 이어야 합니다.");
            }
        }
    }

    private void checkCount(Map<String, List<Integer>> products) {
        for (String product : products.keySet()) {
            if (products.get(product).get(1) == 0) {
                throw new IllegalArgumentException("[ERROR] 상품 수량은 1개 이상 이어야 합니다.");
            }
        }
    }

    public Integer sell(String product, Integer money) {
        checkProduct(product);
        checkCount(product);
        checkMoney(product, money);
        products.get(product).set(1, products.get(product).get(1) - 1);
        return products.get(product).get(0);
    }

    private void checkProduct(String product){
        if (!products.containsKey(product)) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않은 상품 입니다.");
        }
    }

    private void checkMoney(String product, Integer money){
        if (money < products.get(product).get(0)) {
            throw new IllegalArgumentException("[ERROR] 보유한 금액이 상품 가격보다 적습니다.");
        }
    }

    private void checkCount(String product){
        if (products.get(product).get(1) == 0) {
            throw new IllegalArgumentException("[ERROR] 해당 상품은 매진 되었습니다.");
        }
    }


    public Map<String, List<Integer>> get() {
        return Collections.unmodifiableMap(products);
    }

}
