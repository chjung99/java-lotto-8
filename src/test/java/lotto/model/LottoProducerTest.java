package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoProducerTest {
    @Test
    void 입력한_개수_만큼_로또가_생성된다() {
        int amount = 10;
        List<Lotto> lottoTickets = LottoProducer.produce(amount);
        assertThat(lottoTickets).hasSize(amount);
    }
}
