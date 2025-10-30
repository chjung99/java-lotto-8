package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoProducer {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    public static List<Lotto> produce(int amount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT);
            lottoTickets.add(new Lotto(numbers));
        }
        return lottoTickets;
    }
}
