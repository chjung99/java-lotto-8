package lotto.view;

import lotto.model.*;

import java.util.List;
import java.util.Map;

public class OutputView {

    private final String OUTPUT_ORDER_AMOUNT_PROMPT = "개를 구매했습니다.";
    private final String OUTPUT_WINNING_RESULT_HEAD_PROMPT = "당첨 통계";
    private final String OUTPUT_WINNING_RESULT_SPLIT_PROMPT = "---";
    private final String OUTPUT_WINNING_RESULT_FORMAT = "%s개 일치%s (%s) - %d개";
    private final String OUTPUT_WINNING_WITH_BONUS_RESULT_FORMAT = "%s개 일치, 보너스 볼 일치%s (%s) - %d개";
    private final String OUTPUT_PROFIT_RATE_PROMPT = "총 수익률은 %.1f%%입니다.";

    public void printOrderedLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + OUTPUT_ORDER_AMOUNT_PROMPT);
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningResult(LottoOrderResult lottoOrderResult) {
        System.out.println(OUTPUT_WINNING_RESULT_HEAD_PROMPT);
        System.out.println(OUTPUT_WINNING_RESULT_SPLIT_PROMPT);

        Map<Integer, Integer> rankCounts = lottoOrderResult.getRankCounts();
        LottoRankMapper lottoRankMapper = new LottoRankMapper();

        printWinningStatistics(lottoRankMapper, rankCounts);
    }

    private void printWinningStatistics(LottoRankMapper lottoRankMapper, Map<Integer, Integer> rankCounts) {
        for (int matchCount = 3; matchCount <= 6; matchCount++) {
            int rank = lottoRankMapper.getRankByMatchRecord(new MatchRecord(matchCount, false));

            System.out.println(String.format(OUTPUT_WINNING_RESULT_FORMAT,
                    matchCount, "", LottoPrize.getPrizePromptByRank(rank), rankCounts.get(rank)));

            if (matchCount == 5) {
                int bonusRank = lottoRankMapper.getRankByMatchRecord(new MatchRecord(matchCount, true));
                System.out.println(String.format(OUTPUT_WINNING_WITH_BONUS_RESULT_FORMAT,
                        matchCount, "", LottoPrize.getPrizePromptByRank(bonusRank), rankCounts.get(bonusRank)));
            }
        }
    }

    public void printLottoProfitRate(Double lottoProfitRate) {
        System.out.println(String.format(OUTPUT_PROFIT_RATE_PROMPT, lottoProfitRate));
    }
}
