package lotto.domain;

public class Profit {

    private Profit() {
    }

    public static Profit create() {
        return new Profit();
    }

    public double calculate(int purchaseAmount, int totalPrize) {
        double profit = ((double) totalPrize / (double) purchaseAmount) * 100;
        return Math.round(profit * 100)/100.0;
    }

}
