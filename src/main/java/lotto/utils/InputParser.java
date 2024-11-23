package lotto.utils;

import static lotto.exception.ErrorMessage.INVALID_LOTTO_SIZE;
import static lotto.exception.ErrorMessage.INVALID_NUMBER_RANGE;
import static lotto.exception.ErrorMessage.NOT_NUMBER;
import static lotto.exception.ErrorMessage.NUMBER_NOT_DUPLICATE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputParser {

    private static final String SPLITTER = ",";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_SIZE = 6;

    private InputParser() {
    }

    public static InputParser create() {
        return new InputParser();
    }

    public List<Integer> convertUserInput(String userInput) {
        List<String> parses = parse(userInput);
        return parses.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private List<String> parse(String userInput) {
        List<String> splits = Arrays.asList(userInput.split(SPLITTER));
        validateSplits(splits);
        return Arrays.asList(userInput.split(SPLITTER));
    }

    private void validateSplits(List<String> splits) {
        for (String split : splits) {
            validateIsNumber(split);
            validateNumberRange(split);
        }
        validateNumberSize(splits);
        validateDuplicateNumber(splits);
    }

    private void validateIsNumber(String split) {
        if (!NUMBER_PATTERN.matcher(split).matches()) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }

    private void validateNumberRange(String split) {
        int parseSplit = Integer.parseInt(split);
        if (parseSplit < MIN_NUMBER || parseSplit > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private void validateNumberSize(List<String> splits) {
        if (splits.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private void validateDuplicateNumber(List<String> splits) {
        Set<String> validateSplits = new HashSet<>(splits);
        if (validateSplits.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(NUMBER_NOT_DUPLICATE.getMessage());
        }
    }

}
