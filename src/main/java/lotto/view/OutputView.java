package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoPrize;
import lotto.model.LottoResult;

import java.util.List;

public class OutputView {

    private final String OUTPUT_PURCHASE_AMOUNT_PROMPT = "개를 구매했습니다.";
    private final String OUTPUT_WINNING_RESULT_HEAD_PROMPT = "당첨 통계";
    private final String OUTPUT_WINNING_RESULT_SPLIT_PROMPT = "---";
    private final String OUTPUT_WINNING_RESULT_FORMAT = "%s개 일치%s (%s) - %d개";
    private final String OUTPUT_PROFIT_RATE_PROMPT = "총 수익률은 %.1f%%입니다.";

    public void printPurchasedLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + OUTPUT_PURCHASE_AMOUNT_PROMPT);
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningResult(LottoResult lottoResult) {
        System.out.println(OUTPUT_WINNING_RESULT_HEAD_PROMPT);
        System.out.println(OUTPUT_WINNING_RESULT_SPLIT_PROMPT);

        System.out.println(String.format(OUTPUT_WINNING_RESULT_FORMAT,
                3, "", LottoPrize.RANK_5.getPrizeAmountPrompt(), lottoResult.countOf5th));
        System.out.println(String.format(OUTPUT_WINNING_RESULT_FORMAT,
                4, "", LottoPrize.RANK_4.getPrizeAmountPrompt(), lottoResult.countOf4th));
        System.out.println(String.format(OUTPUT_WINNING_RESULT_FORMAT,
                5, "", LottoPrize.RANK_3.getPrizeAmountPrompt(), lottoResult.countOf3rd));
        System.out.println(String.format(OUTPUT_WINNING_RESULT_FORMAT,
                5, ", 보너스 볼 일치", LottoPrize.RANK_2.getPrizeAmountPrompt(), lottoResult.countOf2nd));
        System.out.println(String.format(OUTPUT_WINNING_RESULT_FORMAT,
                6, "", LottoPrize.RANK_1.getPrizeAmountPrompt(), lottoResult.countOf1st));
    }

    public void printLottoProfitRate(Double lottoProfitRate) {
        System.out.println(String.format(OUTPUT_PROFIT_RATE_PROMPT, lottoProfitRate));
    }
}
