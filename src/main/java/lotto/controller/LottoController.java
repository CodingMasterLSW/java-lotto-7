package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void start() {
        inputView.printPurchaseMessage();
        int purchaseAmount = inputView.purchaseInput();
        int count = lottoService.purchaseLotto(purchaseAmount);
        outputView.printPurchaseMessage(count);

        List<Lotto> lottos = lottoService.buy(count);
        outputView.printLotto(lottos);

        inputView.printWinnerNumberMessage();
        String userInput = inputView.winnerInput();
        lottoService.initWinner(userInput);

        inputView.printBonusNumberMessage();
        int bonusNumber = inputView.bonusInput();
        lottoService.initBonus(bonusNumber);

        Map<Rank, Integer> lottoResult = lottoService.calculateLottoResult(lottos);
        outputView.printStatisticMessage();
        outputView.printStatisticResult(lottoResult);
        double profit = lottoService.calculateProfit();
        System.out.println(profit);
    }

}
