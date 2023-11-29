package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Max max = new Max();
        int pobiMax = max.calculate(pobi);
        int crongMax = max.calculate(crong);

        if (pobiMax > crongMax) {
            return 1;
        }
        if (pobiMax < crongMax) {
            return 2;
        }
        if (pobiMax == crongMax) {
            return 0;
        }
    }
}