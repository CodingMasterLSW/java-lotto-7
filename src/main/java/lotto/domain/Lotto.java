package lotto.domain;

import static lotto.exception.ErrorMessage.INVALID_LOTTO_SIZE;
import static lotto.exception.ErrorMessage.NUMBER_NOT_DUPLICATE;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public int countWinningNumber(List<Integer> winningNumber) {
        return (int) winningNumber.stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> tmpNumbers = new HashSet<>(numbers);
        if (tmpNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(NUMBER_NOT_DUPLICATE.getMessage());
        }
    }


}
