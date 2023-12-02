package menu.constants;

public enum CategoryValue {
    CATEGORY_COUNT(5),
    MIN_CATEGORY_NUMBER(1),
    MAX_CATEGORY_NUMBER(5),
    MAX_DUPLICATION_COUNT(2);

    private final Integer categoryValue;

    CategoryValue(Integer categoryValue) {
        this.categoryValue = categoryValue;
    }

    public Integer get() {
        return categoryValue;
    }
}
