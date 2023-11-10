package christmas.constants;

public enum Badge {
    NOTHING("없음", 0),
    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000);


    private final String badge;
    private final Integer minimumAmount;

    Badge(String badge, Integer minimumAmount) {
        this.badge = badge;
        this.minimumAmount = minimumAmount;
    }

    public String getBadge() {
        return badge;
    }

    public Integer getMinimumAmount() {
        return minimumAmount;
    }

    public static Badge grant(Integer totalDiscount) {
        if (totalDiscount >= SANTA.getMinimumAmount()) {
            return SANTA;
        }
        if (totalDiscount >= TREE.getMinimumAmount()) {
            return TREE;
        }
        if (totalDiscount >= STAR.getMinimumAmount()) {
            return STAR;
        }
        return NOTHING;
    }
}
