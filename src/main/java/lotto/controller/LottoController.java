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
        int count = handlePurchaseCount(purchaseAmount);
        List<Lotto> lottos = showPurchaseLotto(count);
        handleWinnerNumber();
        handleBonusNumber();
        handleLottoResult(lottos);
        handleProfit();
    }

    private int getPurchaseAmount() {
        inputView.printPurchaseMessage();
        int purchaseAmount = retryOnInvalidInput(() -> inputView.purchaseInput());
        return purchaseAmount;
    }

    private int handlePurchaseCount(int purchaseAmount) {
        int count = lottoService.purchaseLotto(purchaseAmount);
        outputView.printPurchaseMessage(count);
        return count;
    }

    private void handleBonusNumber() {
        inputView.printBonusNumberMessage();
        retryOnInvalidInput(() -> {
            int bonusNumber = inputView.bonusInput();
            lottoService.initBonus(bonusNumber);
            return null;
        });
    }

    private void handleLottoResult(List<Lotto> lottos) {
        Map<Rank, Integer> lottoResult = lottoService.calculateLottoResult(lottos);
        outputView.printStatisticMessage();
        outputView.printStatisticResult(lottoResult);
    }

    private void handleWinnerNumber() {
        inputView.printWinnerNumberMessage();
        String userInput = retryOnInvalidInput(() -> inputView.winnerInput());
        lottoService.initWinner(userInput);
    }

    private void handleProfit() {
        double profit = lottoService.calculateProfit();
        outputView.printProfit(profit);
    }

    private List<Lotto>  showPurchaseLotto(int count) {
        List<Lotto> lottos = lottoService.buy(count);
        outputView.printLotto(lottos);
        return lottos;
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
