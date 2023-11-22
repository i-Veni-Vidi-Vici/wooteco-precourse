package lotto.domain;

import static lotto.constants.ERROR.LOTTO_DUPLICATION_ERROR;
import static lotto.constants.ERROR.LOTTO_NUMBER_SIZE_ERROR;
import static lotto.constants.ERROR.RANGE_ERROR;
import static lotto.constants.LottoValue.LOTTO_NUMBER_SIZE;
import static lotto.constants.LottoValue.MAX_LOTTO_NUMBER;
import static lotto.constants.LottoValue.MIN_LOTTO_NUMBER;

import java.util.Collections;
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
        if (numbers.size() != LOTTO_NUMBER_SIZE.get()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_ERROR.getMessage());
        }
    }

    private void checkDuplication(List<Integer> numbers) {
        Set<Integer> differentNumbers = new HashSet<>(numbers);

        if (numbers.size() != differentNumbers.size()) {
            throw new IllegalArgumentException(LOTTO_DUPLICATION_ERROR.getMessage());
        }
    }

    private void checkRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if ((number < MIN_LOTTO_NUMBER.get()) || (number > MAX_LOTTO_NUMBER.get())) {
                throw new IllegalArgumentException(RANGE_ERROR.getMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
