package lotto.model.domain;

import java.util.List;

public class LottoOrder {
    private final int orderPrice;
    private final List<Lotto> lottoTickets;

    public LottoOrder(int orderPrice, List<Lotto> lottoTickets) {
        this.orderPrice = orderPrice;
        this.lottoTickets = lottoTickets;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
