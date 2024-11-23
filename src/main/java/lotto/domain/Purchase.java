package lotto.domain;

import static lotto.exception.ErrorMessage.INVALID_PURCHASE_UNIT;

public class Purchase {

    private static final int PURCHASE_UNIT = 1_000;

    private int amount;

    private Purchase(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    public static Purchase from(int amount) {
        return new Purchase(amount);
    }

    private void validateAmount(int amount) {
        if (amount % PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_UNIT.getMessage());
        }
    }
}
