package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    private InputView() {
    }

    public static InputView create() {
        return new InputView();
    }

    public String purchaseInput() {
        return Console.readLine();
    }

    public void printPurchaseMessage() {
        printMessage(PURCHASE_AMOUNT_MESSAGE);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
