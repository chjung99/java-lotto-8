package lotto.model.service;

import lotto.model.domain.LottoOrderResult;
import lotto.model.domain.LottoPrize;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningCalculatorTest {
    @Test
    void 당첨금액을_합한다(){
        //given
        Map<Integer, Integer> rankCounts = new HashMap<>();
        rankCounts.put(1, 1);
        rankCounts.put(2, 1);
        rankCounts.put(3, 0);
        rankCounts.put(4, 0);
        rankCounts.put(5, 0);
        LottoOrderResult lottoOrderResult = new LottoOrderResult(rankCounts);
        WinningCalculator winningCalculator = new WinningCalculator();

        //when
        int totalAmount = winningCalculator.calculateTotal(lottoOrderResult);

        //then
        assertThat(totalAmount).isEqualTo(LottoPrize.getPrizeByRank(1) + LottoPrize.getPrizeByRank(2));
    }
}
