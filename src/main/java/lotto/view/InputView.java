package lotto.view;

import static lotto.exception.ErrorMessage.NOT_INPUT;
import static lotto.exception.ErrorMessage.NOT_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");

    private InputView() {
    }

    public static InputView create() {
        return new InputView();
    }

    public String purchaseInput() {
        String userInput = Console.readLine();
        validateEmpty(userInput);
        validateNumber(userInput);
        return userInput;
    }

    public void printPurchaseMessage() {
        printMessage(PURCHASE_AMOUNT_MESSAGE);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    private void validateEmpty(String userInput) {
        if (userInput.isEmpty() || userInput == null) {
            throw new IllegalArgumentException(NOT_INPUT.getMessage());
        }
    }

    private void validateNumber(String userInput) {
        if (!NUMBER_PATTERN.matcher(userInput).matches()) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }
}
