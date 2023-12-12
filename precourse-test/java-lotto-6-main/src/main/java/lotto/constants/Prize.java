package lotto.constants;

public enum Prize {
    FIFTH(3, "3개 일치", 5_000),
    FOURTH(4, "4개 일치", 50_000),
    THIRD(5, "5개 일치", 1_500_000),
    SECOND(5, "5개 일치, 보너스 볼 일치", 30_000_000),
    FIRST(6, "6개 일치", 2_000_000_000);

    private final Integer matchingCount;
    private final String message;
    private final Integer prizeMoney;

    Prize(Integer matchingCount, String message, Integer prizeMoney) {
        this.matchingCount = matchingCount;
        this.message = message;
        this.prizeMoney = prizeMoney;
    }

    public static Prize calculate(Integer matchingCount, boolean bonusNumber) {
        if (matchingCount.equals(FIRST.matchingCount)) {
            return FIRST;
        }
        if (matchingCount.equals(SECOND.matchingCount)) {
            return calculateSecond(bonusNumber);
        }
        if (matchingCount.equals(FOURTH.matchingCount)) {
            return FOURTH;
        }
        if (matchingCount.equals(FIFTH.matchingCount)) {
            return FIFTH;
        }
        return null;
    }

    private static Prize calculateSecond(boolean bonusNumber) {
        if (bonusNumber) {
            return SECOND;
        }
        return THIRD;
    }

    public String getMessage() {
        return message;
    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }
}
