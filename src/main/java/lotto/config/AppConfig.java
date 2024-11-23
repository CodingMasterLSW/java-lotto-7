package lotto.config;

import lotto.Lotto;
import lotto.service.LottoService;
import lotto.utils.RandomNumber;

public class AppConfig {

    private static final RandomNumber randomNumber = RandomNumber.create();
    private static final Lotto lotto = new Lotto(randomNumber.generate());

    private static LottoService createLottoService() {
        return new LottoService(lotto, randomNumber);
    }

}
