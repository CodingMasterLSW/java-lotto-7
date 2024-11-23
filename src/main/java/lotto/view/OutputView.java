package lotto.view;

import static lotto.domain.Rank.ZERO;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {

    private static final String PURCHASE_MESSAGE = "%s개를 구매했습니다.";
    private static final String STATISTIC_MESSAGE = "당첨 통계";
    private static final String HYPHEN = "---";
    private static final String LOTTO_RESULT = "%s개 일치 (%,d원) - %s개";

    private OutputView() {
    }

    public static OutputView create() {
        return new OutputView();
    }

    public void printPurchaseMessage(int count) {
        printBlank();
        System.out.printf(PURCHASE_MESSAGE, count);
        printBlank();
    }

    public void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printStatisticMessage() {
        printBlank();
        printMessage(STATISTIC_MESSAGE);
        printMessage(HYPHEN);
    }

    public void printStatisticResult(Map<Rank, Integer> result) {
        for (Rank rank : result.keySet()) {
            if (rank == ZERO) {
                continue;
            }
            System.out.printf(LOTTO_RESULT, rank.getMatchCount(), rank.getPrize(),
                    result.get(rank));
            System.out.println();
        }

    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    private void printBlank() {
        System.out.println();
    }

}
