package christmas.domain.promotion.discount;

import christmas.domain.ReservedMenu;

public class Weekend {
    public static Integer calculateWeekend(Integer day, ReservedMenu reservedMenu) {
        if (checkWeekend(day)) {
            return (2023 * reservedMenu.countMain());
        }

        return 0;
    }

    public static boolean checkWeekend(Integer day) {
        for (int i = 0; i < 5; i++) {
            if (day >= ((1 + (7 * i))) && (day <= (2 + (7 * i)))) {
                return true;
            }
        }

        return false;
    }
}
