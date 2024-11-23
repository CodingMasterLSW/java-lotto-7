package lotto.service;

import lotto.Lotto;
import lotto.utils.RandomNumber;

public class LottoService {

    private final Lotto lotto;
    private final RandomNumber randomNumber;

    public LottoService(Lotto lotto, RandomNumber randomNumber) {
        this.lotto = lotto;
        this.randomNumber = randomNumber;
    }

}
