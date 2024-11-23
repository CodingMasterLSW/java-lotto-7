package lotto.domain;

import static lotto.exception.ErrorMessage.WINNER_CONTAINS_BONUS;

import java.util.List;

public class Winner {

    private final List<Integer> numbers;
    private int bonusNumber;

    private Winner(List<Integer> numbers) {
        this.numbers = numbers;
        this.bonusNumber = 0;
    }

    public static Winner of(List<Integer> numbers) {
        return new Winner(numbers);
    }

    public void initBonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validateBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(WINNER_CONTAINS_BONUS.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
