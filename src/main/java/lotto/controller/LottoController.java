package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.config.AppConfig;
import lotto.domain.Purchase;
import lotto.service.LottoService;
import lotto.utils.RandomNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private InputView inputView = InputView.create();
    private OutputView outputView = OutputView.create();
    private RandomNumber randomNumber = RandomNumber.create();
    private Purchase purchase;
    private LottoService lottoService = AppConfig.createLottoService();

    public void start() {
        inputView.printPurchaseMessage();
        String userInput = inputView.purchaseInput();

        purchase = Purchase.from(Integer.parseInt(userInput));
        int count = purchase.calculateCount();
        outputView.printPurchaseMessage(count);

        List<Lotto> lottos = lottoService.buy(count);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

}
