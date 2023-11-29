package onboarding;

import java.util.List;

public class Max {

    private int sum(Integer number) {
        int sum = 0;

        while (number != 0) {
            sum += (number % 10);
            number /= 10;
        }

        return sum;
    }

    private int multiply(Integer number) {
        int multiplication = 1;

        while (number != 0) {
            multiplication *= (number % 10);
            number /= 10;
        }

        return multiplication;
    }

    private int compare(Integer leftNumber, Integer rightNumber) {
        if (leftNumber >= rightNumber) {
            return leftNumber;
        }

        return rightNumber;
    }

    public int calculate(List<Integer> numbers) {
        int sum = compare(sum(numbers.get(0)), sum(numbers.get(1)));
        int multiplication = compare(multiply(numbers.get(0)), multiply(numbers.get(1)));

        if (sum >= multiplication) {
            return sum;
        }

        return multiplication;
    }
}
