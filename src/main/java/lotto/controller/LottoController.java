package lotto.controller;

import lotto.model.domain.*;
import lotto.model.service.LottoChecker;
import lotto.model.service.LottoProducer;
import lotto.model.service.UserInputWinningNumberProvider;
import lotto.util.InputParser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoChecker lottoChecker = new LottoChecker();

    public void run() {

        LottoOrder lottoOrder = getLottoOrder();
        outputView.printOrderedLottoTickets(lottoOrder.getLottoTickets());

        LottoResult lottoResult = generateLottoResult();

        LottoOrderResult lottoOrderResult = generateLottoOrderResult(lottoOrder, lottoResult);
        outputView.printWinningResult(lottoOrderResult);


        Double profitRate = calculateProfitRate(lottoOrder, lottoOrderResult);
        outputView.printLottoProfitRate(profitRate);
    }

    private LottoOrder getLottoOrder() {
        while (true) {
            try {
                String inputOrderPrice = inputView.getOrderPrice();

                int orderPrice = InputParser.parseNaturalNumber(inputOrderPrice);
                List<Lotto> lottoTickets = LottoProducer.produceByWon(orderPrice);

                return new LottoOrder(orderPrice, lottoTickets);
            } catch (IllegalArgumentException e) {
                inputView.printError(e.getMessage());
            }
        }
    }

    private BonusNumber getBonusNumber(Lotto winningLotto) {

        while (true) {
            try {
                String inputBonusNumber = inputView.getBonusNumber();
                return new BonusNumber(InputParser.parseNaturalNumber(inputBonusNumber), winningLotto);
            } catch (IllegalArgumentException e) {
                inputView.printError(e.getMessage());
            }
        }
    }

    private Lotto getWinningLotto() {
        while (true) {
            try {
                String inputWinningNumber = inputView.getWinningNumbers();
                List<Integer> numbers = InputParser.parseNaturalNumberList(inputWinningNumber);
                return new Lotto(numbers);

            } catch (IllegalArgumentException e) {
                inputView.printError(e.getMessage());
            }
        }
    }

    private LottoResult generateLottoResult() {

        Lotto winningLotto = getWinningLotto();
        BonusNumber bonusNumber = getBonusNumber(winningLotto);

        UserInputWinningNumberProvider userInputWinningNumberProvider = new UserInputWinningNumberProvider(winningLotto, bonusNumber);
        LotteryDrum lotteryDrum = new LotteryDrum(userInputWinningNumberProvider);

        return lotteryDrum.getLottoResult();
    }

    private LottoOrderResult generateLottoOrderResult(LottoOrder lottoOrder, LottoResult lottoResult) {
        return lottoChecker.check(lottoOrder, lottoResult);
    }

    private Double calculateProfitRate(LottoOrder lottoOrder, LottoOrderResult lottoOrderResult) {
        return lottoChecker.calculateProfitRate(lottoOrder, lottoOrderResult);

    }

}
