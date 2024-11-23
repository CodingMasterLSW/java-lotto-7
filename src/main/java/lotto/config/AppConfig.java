package lotto.config;

import lotto.service.LottoService;
import lotto.utils.RandomNumber;

public class AppConfig {

    public static LottoService createLottoService() {
        return new LottoService(RandomNumber.create());
    }

}
