package lotto.model.service;

import lotto.model.domain.MatchRecord;
import lotto.model.domain.Lotto;

import java.util.List;

public class LottoJudge {
    private final LottoRankMapper lottoRankMapper;

    public LottoJudge(LottoRankMapper lottoRankMapper) {
        this.lottoRankMapper = lottoRankMapper;
    }

    public int judge(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) lotto.getNumbers().stream().filter(winningNumbers::contains).count();
        boolean isContainBonusNumber = lotto.getNumbers().contains(bonusNumber);

        if (matchCount < 3) return -1;
        return lottoRankMapper.getRankByMatchRecord(new MatchRecord(matchCount, isContainBonusNumber));
    }
}
