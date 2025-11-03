package lotto.model.service;

import lotto.model.domain.LottoOrder;
import lotto.model.domain.LottoOrderResult;
import lotto.model.domain.LottoResult;

public class LottoChecker {
    private final LottoResultAggregator lottoResultAggregator;
    private final ProfitCalculator profitCalculator;
    private final WinningCalculator winningCalculator;

    public LottoChecker() {
        LottoRankMapper lottoRankMapper = new LottoRankMapper();
        LottoJudge lottoJudge = new LottoJudge(lottoRankMapper);
        this.lottoResultAggregator = new LottoResultAggregator(lottoJudge);
        this.profitCalculator = new ProfitCalculator();
        this.winningCalculator = new WinningCalculator();
    }

    public LottoOrderResult check(LottoOrder lottoOrder, LottoResult lottoResult){
        return lottoResultAggregator.aggregate(lottoOrder, lottoResult);
    }

    public double calculateProfitRate(LottoOrder order, LottoOrderResult result) {
        int total = winningCalculator.calculateTotal(result);
        return profitCalculator.calculateProfitRate(order, total);
    }

}