package lotto.model.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.domain.MatchRecord;
import org.junit.jupiter.api.Test;

public class LottoRankMapperTest {
    @Test
    void 정의되지_않은_당첨_기록으로_조회하면_예외가_발생한다(){
        assertThatThrownBy(() -> new LottoRankMapper().getRankByMatchRecord(new MatchRecord(1, true)))
                .isInstanceOf(NullPointerException.class);
    }
}
