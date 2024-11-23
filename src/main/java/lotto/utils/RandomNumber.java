package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_SIZE = 6;

    private RandomNumber() {
    }

    public static RandomNumber create() {
        return new RandomNumber();
    }

    public List<Integer> generate() {
        List<Integer> tmpRandomNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER,
                NUMBER_SIZE);
        List<Integer> randomNumbers = new ArrayList<>(tmpRandomNumbers);
        Collections.sort(randomNumbers);
        return randomNumbers;
    }


}
