package christmas.domain;

public class Benefit {

    public Integer discountXmas(Integer date) {
        if (date <= 25) {
            return 1000 + ((date - 1) * 100);
        }

        return 0;
    }
}
