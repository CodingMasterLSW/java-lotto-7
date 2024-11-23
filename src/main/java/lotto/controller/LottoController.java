package lotto.controller;

import lotto.domain.Purchase;
import lotto.view.InputView;

public class LottoController {

    private InputView inputView = InputView.create();
    private Purchase purchase;

    public void start() {
        inputView.printPurchaseMessage();
        String userInput = inputView.purchaseInput();

        purchase = Purchase.from(Integer.parseInt(userInput));
    }

}
