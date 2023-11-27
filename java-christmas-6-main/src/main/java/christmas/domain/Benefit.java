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
}
