package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Profit;
import lotto.domain.Purchase;
import lotto.domain.Rank;
import lotto.domain.Winner;
import lotto.utils.InputParser;
import lotto.utils.RandomNumber;

public class LottoService {

    private final RandomNumber randomNumber;
    private final LottoResult lottoResult;
    private final Profit profit;
    private final InputParser inputParser;

    public LottoService(RandomNumber randomNumber, InputParser inputParser, LottoResult lottoResult,
            Profit profit) {
        this.randomNumber = randomNumber;
        this.inputParser = inputParser;
        this.lottoResult = lottoResult;
        this.profit = profit;
    }

    public Purchase createPurchase(int purchaseAmount) {
        return Purchase.from(purchaseAmount);
    }

    public int purchaseLotto(Purchase purchase) {
        return purchase.calculateCount();
    }

    public Lottos buy(int count) {
        List<Lotto> tmpLottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(randomNumber.generate());
            tmpLottos.add(lotto);
        }
        Lottos lottos = Lottos.from(tmpLottos);
        return lottos;
    }

    public Winner initWinner(String userInput) {
        List<Integer> winnerNumbers = inputParser.convertUserInput(userInput);
        Winner winner = Winner.of(winnerNumbers);
        return winner;
    }

    public void initBonus(int bonusNumber, Winner winner) {
        winner.initBonusNumber(bonusNumber);
    }

    public LottoResult calculateLottoResult(Lottos lottos, Winner winner) {
        for (Lotto lotto : lottos.getLottos()) {
            int count = lotto.countWinningNumber(winner.getNumbers());
            boolean hasBonusNumber = lotto.hasBonusNumber(winner.getBonusNumber());
            Rank rank = Rank.decisionRank(count, hasBonusNumber);
            lottoResult.calculate(rank);
        }
        return lottoResult;
    }

    public double calculateProfit(Purchase purchase) {
        return profit.calculate(purchase.getAmount(), lottoResult.calculateTotalPrize());
    }

}
