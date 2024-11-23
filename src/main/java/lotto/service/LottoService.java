package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;
import lotto.domain.Purchase;
import lotto.domain.Winner;
import lotto.utils.InputParser;
import lotto.utils.RandomNumber;

public class LottoService {

    private final RandomNumber randomNumber;
    private Lotto lotto;
    private Purchase purchase;
    private InputParser inputParser;

    public LottoService(RandomNumber randomNumber, InputParser inputParser) {
        this.randomNumber = randomNumber;
        this.inputParser = inputParser;
    }

    public int purchaseLotto(int purchaseAmount) {
        purchase = Purchase.from(purchaseAmount);
        return purchase.calculateCount();
    }

    public List<Lotto> buy(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lotto = new Lotto(randomNumber.generate());
            lottos.add(lotto);
        }
        return Collections.unmodifiableList(lottos);
    }

    public void initWinner(String userInput) {
        List<Integer> winnerNumbers = inputParser.convertUserInput(userInput);
        Winner winner = Winner.of(winnerNumbers);
    }
}
