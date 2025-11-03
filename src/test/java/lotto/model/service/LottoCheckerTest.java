package lotto.model.service;

import lotto.model.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCheckerTest {
    @Test
    void lottoOrder와_lottoResult가_주어지면_LottoOrderResult를_반환한다(){
        // given
        Lotto dummyLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoOrder lottoOrder = new LottoOrder(1000, Collections.singletonList(dummyLotto));
        LottoResult lottoResult = new LottoResult(dummyLotto, new BonusNumber(7, dummyLotto));
        LottoChecker lottoChecker = new LottoChecker();

        // when
        var result = lottoChecker.check(lottoOrder, lottoResult);

        // then
        assertThat(result).isNotNull();
    }
}
