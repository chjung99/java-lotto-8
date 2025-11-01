package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoProducer;
import lotto.util.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run(){
        String InputPurchaseAmountInWon = inputView.getPurchaseAmountInWon();
        int purchaseAmountInWon = InputValidator.validatePurchaseAmountInWon(InputPurchaseAmountInWon);
        List<Lotto> lottoTickets = LottoProducer.produceByWon(purchaseAmountInWon);
        outputView.printPurchasedLottoTickets(lottoTickets);
    }
}
