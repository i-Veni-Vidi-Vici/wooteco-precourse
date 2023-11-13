package christmas.domain.promotion.giveaway;

public class Champagne {
    public static boolean checkFreeGift(Integer totalAmount) {
        return ((totalAmount / 120000) > 0);
    }

    public static Integer calculateFreeGift(Integer totalAmount) {
        if (checkFreeGift(totalAmount)) {
            return 25000;
        }
        return 0;
    }
}
