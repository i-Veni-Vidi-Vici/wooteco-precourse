package christmas.domain;

public class Benefit {


    private boolean isTarget(Integer purchaseAmount) {
        if (purchaseAmount >= 10_000) {
            return true;
        }

        return false;
    }

    private Integer discountXmas(Integer date) {
        if (date <= 25) {
            return 1000 + ((date - 1) * 100);
        }

        return 0;
    }

    private Integer discountWeekday(Integer date, Integer dessertCount) {
        for (int week = 0; week < 5; week++) {
            if ((date >= (3 + (7 * week))) && (date <= (7 + (7 * week))) && (date <= 31)) {
                return dessertCount * 2023;
            }
        }

        return 0;
    }

    private Integer discountWeekend(Integer date, Integer mainCount) {
        for (int week = 0; week < 5; week++) {
            if ((date == (1 + (7 * week))) || (date == (2 + (7 * week)))) {
                return mainCount * 2023;
            }
        }

        return 0;
    }

    private Integer discountSpecial(Integer date) {
        for (int week = 0; week < 5; week++) {
            if ((date == (3 + (7 * week))) || date == 25) {
                return 1000;
            }
        }

        return 0;
    }

    public Integer presentGiveaway(Integer purchaseAmount) {
        if (purchaseAmount >= 120_000) {
            return 25_000;
        }

        return 0;
    }

    private Integer calculateDiscountAmount(ReservedDate reservedDate, ReservedMenu reservedMenu) {
        return discountXmas(reservedDate.get())
                + discountWeekday(reservedDate.get(), reservedMenu.countDessert())
                + discountWeekend(reservedDate.get(), reservedMenu.countMain())
                + discountSpecial(reservedDate.get());

    }

    public Integer calculateBenefitAmount(ReservedDate reservedDate, ReservedMenu reservedMenu) {
        if (isTarget(reservedMenu.calculateAmount())) {
            return calculateDiscountAmount(reservedDate, reservedMenu)
                    + presentGiveaway(reservedMenu.calculateAmount());
        }

        return 0;
    }

    public Integer calculatePaymentAmount(ReservedDate reservedDate, ReservedMenu reservedMenu) {
        if (isTarget(reservedMenu.calculateAmount())) {
            return reservedMenu.calculateAmount() - calculateDiscountAmount(reservedDate, reservedMenu);
        }

        return reservedMenu.calculateAmount();
    }
}
