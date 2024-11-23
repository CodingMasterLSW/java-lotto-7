package lotto.controller;

import java.util.List;
import lotto.Lotto;
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
        String bonusNumber = inputView.bonusInput();

    }

}
