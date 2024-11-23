package lotto.exception;

public enum ErrorMessage {
    NOT_INPUT("공백을 입력했습니다. 다시 입력해주세요.");

    private static final String ERROR_PREFIX= "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
