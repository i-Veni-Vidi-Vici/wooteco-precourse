package christmas.constants;

public enum Badge {
    SANTA("산타"),
    TREE("트리"),
    STAR("별"),
    NOTHING("없음");

    private final String badge;

    Badge(String badge) {
        this.badge = badge;
    }

    public String getBadge() {
        return badge;
    }

    public static Badge grant(Integer benefitAmount) {
        if (benefitAmount >= 20_000) {
            return SANTA;
        }
        if (benefitAmount >= 10_000) {
            return TREE;
        }
        if (benefitAmount >= 5_000) {
            return STAR;
        }
        return NOTHING;
    }
}
