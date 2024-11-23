package lotto.exception;

public enum ErrorMessage {
    NOT_INPUT("공백을 입력했습니다. 다시 입력해주세요."),
    NOT_NUMBER("입력은 양의 정수만 가능합니다. 다시 입력해주세요."),
    INVALID_NUMBER_RANGE("입력은 1~45 사이의 숫자만 가능합니다. 다시 입력해주세요."),
    NUMBER_NOT_DUPLICATE("당첨번호는 중복된 숫자가 존재해서는 안 됩니다. 다시 입력해주세요."),
    WINNER_CONTAINS_BONUS("보너스 번호가 당첨번호에 이미 존재합니다. 다시 입력해해주세요"),
    INVALID_PURCHASE_UNIT("구매 단위는 1000원입니다. 다시 입력해주세요"),
    INVALID_LOTTO_SIZE("로또 번호는 6개여야 합니다.");

    private static final String ERROR_PREFIX= "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
