package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.domain.Purchase;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private Purchase purchase;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void start() {
        inputView.printPurchaseMessage();
        String userInput = inputView.purchaseInput();

        purchase = Purchase.from(Integer.parseInt(userInput));
        int count = purchase.calculateCount();
        outputView.printPurchaseMessage(count);

        List<Lotto> lottos = lottoService.buy(count);
        outputView.printLotto(lottos);
    }

}
