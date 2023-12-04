package vendingmachine.domain;

public class User {
    private Integer money;

    public User(Integer money) {
        this.money = money;
    }

    public void purchase(Integer price) {
        if (money >= price) {
            money -= price;
        }
        if (money < price) {
            throw new IllegalArgumentException("[ERROR] 보유한 금액이 상품 가격보다 적습니다.");
        }
    }

    public Integer getMoney() {
        return money;
    }
}
