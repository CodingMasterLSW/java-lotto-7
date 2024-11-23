package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    private Lotto lotto;
    private Purchase purchase;
    private InputParser inputParser;
    private Winner winner;
    private Lottos lottos;
    private LottoResult lottoResult = LottoResult.create();
    private Profit profit = Profit.create();

    public LottoService(RandomNumber randomNumber, InputParser inputParser) {
        this.randomNumber = randomNumber;
        this.inputParser = inputParser;
    }

    public int purchaseLotto(int purchaseAmount) {
        purchase = Purchase.from(purchaseAmount);
        return purchase.calculateCount();
    }

    public List<Lotto> buy(int count) {
        List<Lotto> tmpLottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lotto = new Lotto(randomNumber.generate());
            tmpLottos.add(lotto);
        }
        lottos = Lottos.from(tmpLottos);
        return lottos.getLottos();
    }

    public void initWinner(String userInput) {
        List<Integer> winnerNumbers = inputParser.convertUserInput(userInput);
        winner = Winner.of(winnerNumbers);
    }

    public void initBonus(int bonusNumber) {
        winner.initBonusNumber(bonusNumber);
    }

    public Map<Rank, Integer> calculateLottoResult(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int count = lotto.countWinningNumber(winner.getNumbers());
            boolean hasBonusNumber = lotto.hasBonusNumber(winner.getBonusNumber());
            Rank rank = Rank.decisionRank(count, hasBonusNumber);
            lottoResult.calculate(rank);
        }
        return lottoResult.getResult();
    }

    public double calculateProfit() {
        return profit.calculate(purchase.getAmount(), lottoResult.calculateTotalPrize());
    }


}
