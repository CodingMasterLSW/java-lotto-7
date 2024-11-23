package lotto.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoResult {

    private Map<Rank, Integer> result = new LinkedHashMap<>();

    private LottoResult() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public static LottoResult create() {
        return new LottoResult();
    }

    public void calculate(Rank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    public Map<Rank, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }

    public int calculateTotalPrize() {
        int totalPrize = 0;
        for (Rank rank : result.keySet()) {
            totalPrize += (rank.getPrize() * result.get(rank));
        }
        return totalPrize;
    }
}
