package christmas.domain;

public class Benefit {

    private void checkTarget() {

    }

    public Integer discountXmas(Integer date) {
        if (date <= 25) {
            return 1000 + ((date - 1) * 100);
        }

        return 0;
    }

    public Integer discountWeekday(Integer date, Integer dessertCount) {
        for (int week = 0; week < 5; week++) {
            if ((date >= (3 + (7 * week))) && (date <= (7 + (7 * week))) && (date <= 31)) {
                return dessertCount * 2023;
            }
        }

        return 0;
    }

    public Integer discountWeekend(Integer date, Integer mainCount) {
        for (int week = 0; week < 5; week++) {
            if ((date == (1 + (7 * week))) || (date == (2 + (7 * week)))) {
                return mainCount * 2023;
            }
        }

        return 0;
    }

    public Integer discountSpecial(Integer date) {
        for (int week = 0; week < 5; week++) {
            if ((date == (3 + (7 * week))) || date == 25) {
                return 1000;
            }
        }

        return 0;
    }

    public boolean presentGiveaway(Integer purchaseAmount) {
        if (purchaseAmount >= 120_000) {
            return true;
        }

        return false;
    }

    public String grantBadge(Integer benefitAmount) {
        if (benefitAmount >= 20_000) {
            return "산타";
        }
        if (benefitAmount >= 10_000) {
            return "트리";
        }
        if (benefitAmount >= 5_000) {
            return "별";
        }
        return "없음";
    }
}
