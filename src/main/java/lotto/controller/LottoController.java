package lotto.controller;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
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
        int purchaseAmount = getPurchaseAmount();
        int count = lottoService.purchaseLotto(purchaseAmount);
        outputView.printPurchaseMessage(count);

        List<Lotto> lottos = lottoService.buy(count);
        outputView.printLotto(lottos);

        inputView.printWinnerNumberMessage();
        String userInput = retryOnInvalidInput(() -> inputView.winnerInput());
        lottoService.initWinner(userInput);

        inputView.printBonusNumberMessage();

        retryOnInvalidInput(() -> {
            int bonusNumber = inputView.bonusInput();
            lottoService.initBonus(bonusNumber);
            return null;
        });

        Map<Rank, Integer> lottoResult = lottoService.calculateLottoResult(lottos);
        outputView.printStatisticMessage();
        outputView.printStatisticResult(lottoResult);
        double profit = lottoService.calculateProfit();
        outputView.printProfit(profit);
    }

    private int getPurchaseAmount() {
        inputView.printPurchaseMessage();
        int purchaseAmount = retryOnInvalidInput(() -> inputView.purchaseInput());
        return purchaseAmount;
    }

    private <T> T retryOnInvalidInput(Supplier<T> input) {
        while (true) {
            try {
                return input.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

}
