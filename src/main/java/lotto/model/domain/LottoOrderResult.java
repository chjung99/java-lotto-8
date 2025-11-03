package lotto.model.domain;

import java.util.Map;

public class LottoOrderResult {
    private final Map<Integer, Integer> rankCounts;

    public LottoOrderResult(Map<Integer, Integer> rankCounts) {
        this.rankCounts = rankCounts;
    }

    public Map<Integer, Integer> getRankCounts() {
        return rankCounts;
    }
}
