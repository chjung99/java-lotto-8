package lotto.model.service;

import lotto.model.domain.BonusNumber;
import lotto.model.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoJudgeTest {
    @Test
    void 일치하는_숫자_개수가_3개_미만이면_등수는_마이너스_1(){
        //given
        LottoRankMapper lottoRankMapper = new LottoRankMapper();
        LottoJudge lottoJudge = new LottoJudge(lottoRankMapper);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 7, 8, 9, 10));
        BonusNumber bonusNumber = new BonusNumber(11, winningLotto);

        //when
        int rank = lottoJudge.judge(lotto, winningLotto.getNumbers(), bonusNumber.getValue());

        //then
        assertThat(rank).isEqualTo(-1);
    }
}
