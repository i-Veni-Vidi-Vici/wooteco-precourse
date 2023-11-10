package christmas.constants;

import static christmas.constants.Type.APPETIZER;
import static christmas.constants.Type.DESSERT;
import static christmas.constants.Type.DRINK;
import static christmas.constants.Type.MAIN;

public enum Food {
    MUSHROOM_SOUP("양송이수프", APPETIZER, 6_000),
    TAPAS("타파스", APPETIZER, 5_500),
    CAESAR_SALAD("시저샐러드", APPETIZER, 8_000),

    T_BONE_STEAK("티본스테이크", MAIN, 55_000),
    BBQ_RIBS("바비큐립", MAIN, 54_000),
    SEAFOOD_PASTA("해산물파스타", MAIN, 35_000),
    CHRISTMAS_PASTA("크리스마스파스타", MAIN, 25_000),

    CHOCO_CAKE("초코케이크", DESSERT, 15_000),
    ICE_CREAM("아이스크림", DESSERT, 5_000),

    ZERO_COLA("제로콜라", DRINK, 3_000),
    RED_WINE("레드와인", DRINK, 60_000),
    CHAMPAGNE("샴페인", DRINK, 25_000);

    private final String name;
    private final Type type;

    private final int price;

    Food(String name, Type type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


    public Type getType() {
        return type;
    }
}


