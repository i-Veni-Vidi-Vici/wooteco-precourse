package christmas.domain;

public class DiscountPolicy {

    public static Integer calculateChristmas(Integer day) {
        return (1000 + ((day - 1) * 100));
    }

    public static boolean checkTarget(Integer totalAmount) {
        return (totalAmount >= 10000);
    }

}
