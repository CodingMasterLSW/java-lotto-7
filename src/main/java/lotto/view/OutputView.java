package lotto.view;

import java.util.List;
import lotto.Lotto;

public class OutputView {

    private static final String PURCHASE_MESSAGE = "%s개를 구매했습니다.";

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

    private void printMessage(String message) {
        System.out.println(message);
    }

    private void printBlank() {
        System.out.println();
    }

}
