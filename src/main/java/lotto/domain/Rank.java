package lotto.domain;

public enum Rank {

    ZERO(0, 0, false),
    FIFTH_PLACE(3, 5_000, false),
    FOURTH_PLACE(4, 50_000, false),
    THIRD_PLACE(5, 1_500_000, false),
    SECOND_PLACE(5, 30_000_000, true),
    FIRST_PLACE(6, 2_000_000_000, false);

    private int matchCount;
    private int prize;
    private boolean hasBonusNumber;

    Rank(int matchCount, int prize, boolean hasBonusNumber) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static Rank decisionRank(int matchCount, boolean hasBonusNumber) {
        if (matchCount == 3) {
            return FIFTH_PLACE;
        }
        if (matchCount == 4) {
            return FOURTH_PLACE;
        }

        if (matchCount == 5 && !hasBonusNumber) {
            return THIRD_PLACE;
        }

        if (matchCount == 5 && hasBonusNumber) {
            return SECOND_PLACE;
        }

        if (matchCount == 6) {
            return FIRST_PLACE;
        }

        return ZERO;
    }

}
