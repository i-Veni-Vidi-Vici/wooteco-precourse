package christmas.domain;

public class DiscountPolicy {

    public static Integer calculateChristmas(Integer day) {
        return (1000 + ((day - 1) * 100));
    }

    public static boolean checkTarget(Integer totalAmount) {
        return (totalAmount >= 10000);
    }

    public static boolean checkChristmasPeriod(Integer day) {
        return (day <= 25);
    }

    public static Integer calculateWeekday(Integer day) {
        if (checkWeekdayPeriod(day)) {
            return 2023;
        }
        return 0;
    }


    public static boolean checkWeekdayPeriod(Integer day) {
        for (int i = 0; i < 5; i++) {
            if (day >= ((3 + (7 * i))) && (day <= (7 + (7 * i)))) {
                return true;
            }
        }
        return false;
    }
}
