package lotto.config;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.utils.InputParser;
import lotto.utils.RandomNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    public static LottoService createLottoService() {
        return new LottoService(RandomNumber.create(), InputParser.create());
    }

    public static LottoController createLottoController() {
        return new LottoController(InputView.create(), OutputView.create(), createLottoService());
    }

}
