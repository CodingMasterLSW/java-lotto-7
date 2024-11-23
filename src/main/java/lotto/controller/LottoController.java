package lotto.controller;

import java.util.function.Supplier;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Purchase;
import lotto.domain.Winner;
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
        Purchase purchase = lottoService.createPurchase(purchaseAmount);

        int count = handlePurchaseCount(purchase);
        Lottos lottos = showPurchaseLotto(count);
        Winner winner = handleWinnerNumber();
        handleBonusNumber(winner);
        handleLottoResult(lottos, winner);
        handleProfit(purchase);
    }

    private int getPurchaseAmount() {
        inputView.printPurchaseMessage();
        int purchaseAmount = retryOnInvalidInput(() -> inputView.purchaseInput());
        return purchaseAmount;
    }

    private int handlePurchaseCount(Purchase purchase) {
        int count = lottoService.purchaseLotto(purchase);
        outputView.printPurchaseMessage(count);
        return count;
    }

    private void handleBonusNumber(Winner winner) {
        inputView.printBonusNumberMessage();
        retryOnInvalidInput(() -> {
            int bonusNumber = inputView.bonusInput();
            lottoService.initBonus(bonusNumber, winner);
            return null;
        });
    }

    private void handleLottoResult(Lottos lottos, Winner winner) {
        LottoResult lottoResult = lottoService.calculateLottoResult(lottos, winner);
        outputView.printStatisticMessage();
        outputView.printStatisticResult(lottoResult);
    }

    private Winner handleWinnerNumber() {
        inputView.printWinnerNumberMessage();
        String userInput = retryOnInvalidInput(() -> inputView.winnerInput());
        Winner winner = lottoService.initWinner(userInput);
        return winner;
    }

    private void handleProfit(Purchase purchase) {
        double profit = lottoService.calculateProfit(purchase);
        outputView.printProfit(profit);
    }

    private Lottos showPurchaseLotto(int count) {
        Lottos lottos = lottoService.buy(count);
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
