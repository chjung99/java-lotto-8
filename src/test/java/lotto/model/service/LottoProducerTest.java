package lotto.model.service;

import lotto.model.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoProducerTest {
    @Test
    void 입력한_금액_만큼_로또가_생성된다() {
        int amountInWon = 5_000;
        int amount = amountInWon / 1_000;
        List<Lotto> lottoTickets = LottoProducer.produceByWon(amountInWon);
        assertThat(lottoTickets).hasSize(amount);
    }
}
