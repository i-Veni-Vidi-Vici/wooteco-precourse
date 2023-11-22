package lotto.constants;

public enum LottoValue {
    LOTTO_NUMBER_SIZE(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45);

    private final Integer value;

    LottoValue(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}
