package christmas.domain.promotion.discount;

public class Xmas {

    public static Integer calculateChristmas(Integer day) {
        if (checkChristmasPeriod(day)) {
            return (1000 + ((day - 1) * 100));
        }

        return 0;
    }

    public static boolean checkChristmasPeriod(Integer day) {
        return (day <= 25);
    }
}
