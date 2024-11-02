package domain;

import java.util.Map;

public class Profit {

    public static double calculate(Map<WinningPrice, Integer> winningPrice, int purchaseAmount) {
        double totalPrice = 0;
        for (WinningPrice price : winningPrice.keySet()) {
            totalPrice += (price.getPrice() * winningPrice.get(price));
        }
        double percentage = (totalPrice / purchaseAmount) * 100;

        return Math.round(percentage * 100.0) / 100.0;
    }

}
