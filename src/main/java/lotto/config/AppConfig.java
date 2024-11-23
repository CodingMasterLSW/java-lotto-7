package lotto.config;

import lotto.controller.LottoController;
import lotto.domain.LottoResult;
import lotto.domain.Profit;
import lotto.service.LottoService;
import lotto.utils.InputParser;
import lotto.utils.RandomNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    public static LottoService createLottoService() {
        return new LottoService(RandomNumber.create(), InputParser.create(), LottoResult.create(),
                Profit.create());
    }

    public static LottoController createLottoController() {
        return new LottoController(InputView.create(), OutputView.create(), createLottoService());
    }

}
