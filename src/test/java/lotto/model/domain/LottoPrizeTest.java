package lotto.model.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoPrizeTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 6, 7})
    void 순위가_1등에서_5등_사이가_아닐_때_상금을_조회하면_예외가_발생한다(int rank) {
        assertThatThrownBy(() -> LottoPrize.getPrizeByRank(rank));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 6, 7})
    void 순위가_1등에서_5등_사이가_아닐_때_상금_출력을_조회하면_예외가_발생한다(int rank) {
        assertThatThrownBy(() -> LottoPrize.getPrizePromptByRank(rank));
    }

}
