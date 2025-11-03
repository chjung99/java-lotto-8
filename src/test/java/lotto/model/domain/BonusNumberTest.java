package lotto.model.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 보너스_번호가_1과_45_사이가_아니면_예외가_발생한다(int value){
        assertThatThrownBy(() -> new BonusNumber(value, new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
