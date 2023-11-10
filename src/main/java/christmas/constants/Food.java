package christmas.constants;

public enum Food {
    MUSHROOM_SOUP("양송이수프", "애피타이저", 6_000),
    TAPAS("타파스", "애피타이저", 5_500),
    CAESAR_SALAD("시저샐러드", "애피타이저", 8_000),

    T_BONE_STEAK("티본스테이크", "메인", 55_000),
    BBQ_RIBS("바비큐립", "메인", 54_000),
    SEAFOOD_PASTA("해산물파스타", "메인", 35_000),
    CHRISTMAS_PASTA("크리스마스파스타", "메인", 25_000),

    CHOCO_CAKE("초코케이크", "디저트", 15_000),
    ICE_CREAM("아이스크림", "디저트", 5_000),

    ZERO_COLA("제로콜라", "음료", 3_000),
    RED_WINE("레드와인", "음료", 60_000),
    CHAMPAGNE("샴페인", "음료", 25_000);

    private final String name;
    private final String type;

    private final int price;

    Food(String name, String type, int price) {
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

    public String getType() {
        return type;
    }
}


