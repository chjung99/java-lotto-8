package lotto.model.domain;

import lotto.model.service.WinningNumberProvider;

public class LotteryDrum {
    private final LottoResult lottoResult;

    public LotteryDrum(WinningNumberProvider winningNumberProvider) {
        this.lottoResult = winningNumberProvider.provide();
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }
}
