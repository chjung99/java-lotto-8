package lotto.model;

import java.util.Map;

public class WinningCalculator {
    public int calculateTotal(LottoOrderResult lottoOrderResult) {
        int totalWinningAmount = 0;
        Map<Integer, Integer> rankCounts = lottoOrderResult.getRankCounts();

        for (int rank : rankCounts.keySet()) {
            totalWinningAmount += rankCounts.get(rank) * LottoPrize.getPrizeByRank(rank);
        }

        return totalWinningAmount;
    }
}
