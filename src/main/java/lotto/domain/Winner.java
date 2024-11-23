package lotto.domain;

import java.util.List;

public class Winner {

    private List<Integer> numbers;
    private int bonusNumber;

    private Winner(List<Integer> numbers) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public static Winner of(List<Integer> numbers) {
        return new Winner(numbers);
    }

}
