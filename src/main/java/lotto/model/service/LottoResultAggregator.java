package lotto.model.service;

import lotto.model.domain.LottoOrderResult;
import lotto.model.domain.LottoResult;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultAggregator {
    private final LottoJudge lottoJudge;

    public LottoResultAggregator(LottoJudge lottoJudge) {
        this.lottoJudge = lottoJudge;
    }

    public LottoOrderResult aggregate(LottoOrder lottoOrder, LottoResult lottoResult) {
        int bonusNumberValue = lottoResult.getBonusNumber().getValue();

        Map<Integer, Integer> rankCounts = new HashMap<>();
        for (int rank = 1; rank <= 5; rank++) rankCounts.put(rank, 0);

        List<Lotto> lottoTickets = lottoOrder.getLottoTickets();
        List<Integer> winningNumbers = lottoResult.getWinningLotto().getNumbers();

        for (Lotto lotto : lottoTickets) {
            int rank = lottoJudge.judge(lotto, winningNumbers, bonusNumberValue);
            if (rank == -1) continue;
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }
        return new LottoOrderResult(rankCounts);
    }
}
