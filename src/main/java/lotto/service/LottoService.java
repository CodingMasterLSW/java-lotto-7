package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;
import lotto.utils.RandomNumber;

public class LottoService {

    private Lotto lotto;
    private final RandomNumber randomNumber;

    public LottoService(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
    }

    public List<Lotto> buy(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for(int i=0; i<count; i++) {
            lotto = new Lotto(randomNumber.generate());
            lottos.add(lotto);
        }
        return Collections.unmodifiableList(lottos);
    }

}
