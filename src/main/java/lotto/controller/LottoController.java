package lotto.controller;

import lotto.domain.Purchase;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private InputView inputView = InputView.create();
    private OutputView outputView = OutputView.create();
    private Purchase purchase;

    public void start() {
        inputView.printPurchaseMessage();
        String userInput = inputView.purchaseInput();

        purchase = Purchase.from(Integer.parseInt(userInput));
        int count = purchase.calculateCount();
        outputView.printPurchaseMessage(count);
    }

}
