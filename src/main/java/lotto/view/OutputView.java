package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {

    private final String OUTPUT_PURCHASE_AMOUNT = "개를 구매했습니다.";

    public void printPurchasedLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + OUTPUT_PURCHASE_AMOUNT);
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers());
        }
    }
}
