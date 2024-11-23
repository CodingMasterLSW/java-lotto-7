package lotto.view;

import static lotto.exception.ErrorMessage.INVALID_NUMBER_RANGE;
import static lotto.exception.ErrorMessage.NOT_INPUT;
import static lotto.exception.ErrorMessage.NOT_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    private static final String WINNER_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private InputView() {
    }

    public static InputView create() {
        return new InputView();
    }

    public int purchaseInput() {
        String userInput = Console.readLine();
        validateEmpty(userInput);
        validateNumber(userInput);
        return Integer.parseInt(userInput);
    }

    public void printPurchaseMessage() {
        printMessage(PURCHASE_AMOUNT_MESSAGE);
    }

    public void printWinnerNumberMessage() {
        printMessage(WINNER_NUMBER_MESSAGE);
    }

    public String winnerInput() {
        String userInput = Console.readLine();
        validateEmpty(userInput);
        return userInput;
    }

    public void printBonusNumberMessage() {
        printBlank();
        printMessage(BONUS_NUMBER_MESSAGE);
    }

    public int bonusInput() {
        String userInput = Console.readLine();
        validateEmpty(userInput);
        validateNumber(userInput);
        validateNumberRange(userInput);
        return Integer.parseInt(userInput);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    private void printBlank() {
        System.out.println();
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

    private void validateNumberRange(String userInput) {
        int parseUserInput = Integer.parseInt(userInput);
        if (parseUserInput < MIN_NUMBER || parseUserInput > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }
}
