package lotto.model.service;

import lotto.model.domain.Lotto;
import lotto.model.domain.LottoOrder;
import lotto.model.domain.LottoPrize;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProfitCalculatorTest {
    @Test
    void 수익률을_계산해서_소수점_둘째자리에서_반올림_한다(){
        //given
        Lotto dummyLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottoTicket = new ArrayList<>(Arrays.asList(dummyLotto, dummyLotto, dummyLotto));
        LottoOrder lottoOrder = new LottoOrder(3000, lottoTicket);
        int totalWinningAmount = LottoPrize.RANK_5.getPrizeAmount();
        ProfitCalculator profitCalculator = new ProfitCalculator();

        //when
        double profitRate = profitCalculator.calculateProfitRate(lottoOrder, totalWinningAmount);

        //then
        assertThat(profitRate).isEqualTo(166.7);
    }
}
