package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoProducer {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_TICKET_PRICE_IN_WON = 1_000;

    private static List<Lotto> produce(int amount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT);
            lottoTickets.add(new Lotto(numbers));
        }
        return lottoTickets;
    }

    private static void validatePriceInWon(int price) {
        if (price % LOTTO_TICKET_PRICE_IN_WON != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다");
        }
    }

    public static List<Lotto> produceByWon(int price) {
        validatePriceInWon(price);
        return produce(price / LOTTO_TICKET_PRICE_IN_WON);
    }

}
