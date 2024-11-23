package lotto.controller;

import lotto.view.InputView;

public class LottoController {

    private InputView inputView = InputView.create();

    public void start() {
        inputView.printPurchaseMessage();
        inputView.purchaseInput();
    }

}
