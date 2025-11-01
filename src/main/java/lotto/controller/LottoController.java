package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoChecker;
import lotto.model.LottoProducer;
import lotto.model.LottoResult;
import lotto.util.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoChecker lottoChecker = new LottoChecker();

    public void run() {
        String InputPurchaseAmountInWon = inputView.getPurchaseAmountInWon();
        int purchaseAmountInWon = InputValidator.validatePurchaseAmountInWon(InputPurchaseAmountInWon);
        List<Lotto> lottoTickets = LottoProducer.produceByWon(purchaseAmountInWon);
        outputView.printPurchasedLottoTickets(lottoTickets);

        String inputWinningNumber = inputView.getWinningNumbers();
        List<Integer> winningNumbers = InputValidator.parseWinningNumbers(inputWinningNumber);

        String inputBonusNumber = inputView.getBonusNumber();
        int bonusNumber = InputValidator.parseBonusNumber(inputBonusNumber);

        LottoResult lottoResult = lottoChecker.getLottoResult(lottoTickets, winningNumbers, bonusNumber);
        outputView.printWinningResult(lottoResult);

        Double lottoProfitRate = lottoChecker.calculateProfitRate(purchaseAmountInWon, lottoResult);
        outputView.printLottoProfitRate(lottoProfitRate);
    }
}
