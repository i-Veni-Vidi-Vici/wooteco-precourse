package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplication(numbers);
        checkRange(numbers);
        this.numbers = numbers;
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplication(List<Integer> numbers) {
        Set<Integer> differentNumbers = new HashSet<>(numbers);
        if (numbers.size() != differentNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if ((number < 1) || (number > 45)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
