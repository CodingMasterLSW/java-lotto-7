package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.Lotto;
import domain.LottoResult;
import domain.Lottos;
import java.util.List;
import service.WinningService;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final WinningService winningService = new WinningService();


    public void start() {
        Lottos lottos = winningService.generateLottoNumber(InputView.purchasePriceInput());
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
        List<Integer> winningNumbers = InputView.winningNumberInput();
        int bonusNumber = InputView.bonusNumberInput();

        for (Lotto lotto : lottos.getLottos()) {
            winningService.winningStatistics(winningNumbers, lotto.getNumbers(), bonusNumber);
        }

        OutputView.printResult(winningService.getLottoResult());
    }
}
