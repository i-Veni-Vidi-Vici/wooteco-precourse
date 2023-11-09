package christmas.domain;

public class Discount {

    public static Integer calculateChristmas(Integer day) {
        return (1000 + (day * 100));
    }

    public static boolean checkTarget(Integer totalAmount) {
        return (totalAmount >= 10000);
    }

}
