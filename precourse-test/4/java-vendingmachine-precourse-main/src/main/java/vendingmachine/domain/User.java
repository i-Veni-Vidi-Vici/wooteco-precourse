package vendingmachine.domain;

public class User {
    private Integer money;

    public User(Integer money) {
        this.money = money;
    }

    public void pay(Integer price) {
        if (money >= price) {
            money -= price;
        }
    }

    public Integer getMoney() {
        return money;
    }
}
