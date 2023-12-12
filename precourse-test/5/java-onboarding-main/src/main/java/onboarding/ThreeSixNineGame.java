package onboarding;

import java.util.List;

public class ThreeSixNineGame {
    public Integer calculateClap(Integer number) {
        Integer clapCount = 0;

        for (int count = 1; count <= number; count++) {
            int countNumber = count;
            while (countNumber != 0) {
                if (List.of(3, 6, 9).contains(countNumber % 10)) {
                    clapCount++;
                }
                countNumber /= 10;
            }
        }

        return clapCount;
    }
}
