package lotto.model;

import java.util.List;

public class LottoChecker {
    private int getNumberOfContain(List<Integer> sourceNumbers, List<Integer> targetNumbers) {
        int count = 0;
        for (int number : targetNumbers) {
            if (sourceNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean isContainBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private int getRankOfLotto(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int count = getNumberOfContain(lotto.getNumbers(), winningNumbers);
        if (count == 3) {
            return 5;
        }
        if (count == 4) {
            return 4;
        }
        if (count == 5 && !isContainBonusNumber(lotto, bonusNumber)) {
            return 3;
        }
        if (count == 5 && isContainBonusNumber(lotto, bonusNumber)) {
            return 2;
        }
        if (count == 6) {
            return 1;
        }
        return -1;
    }

    public LottoOrderResult getOrderResult(LottoOrder lottoOrder, LottoResult lottoResult) {
        List<Lotto> lottoTickets = lottoOrder.getLottoTickets();
        List<Integer> winningNumbers = lottoResult.getWinningLotto().getNumbers();
        int bonusNumberValue = lottoResult.getBonusNumber().getValue();

        int countOf1st = 0;
        int countOf2nd = 0;
        int countOf3rd = 0;
        int countOf4th = 0;
        int countOf5th = 0;

        for (Lotto lotto : lottoTickets) {

            int rank = getRankOfLotto(lotto, winningNumbers, bonusNumberValue);

            if (rank == 1) countOf1st++;
            if (rank == 2) countOf2nd++;
            if (rank == 3) countOf3rd++;
            if (rank == 4) countOf4th++;
            if (rank == 5) countOf5th++;
        }

        return new LottoOrderResult(countOf1st, countOf2nd, countOf3rd, countOf4th, countOf5th);
    }

    private int getTotalWinningAmount(LottoOrderResult lottoOrderResult) {
        int totalWinningAmount = 0;

        totalWinningAmount += lottoOrderResult.countOf1st * LottoPrize.RANK_1.getPrizeAmount();
        totalWinningAmount += lottoOrderResult.countOf2nd * LottoPrize.RANK_2.getPrizeAmount();
        totalWinningAmount += lottoOrderResult.countOf3rd * LottoPrize.RANK_3.getPrizeAmount();
        totalWinningAmount += lottoOrderResult.countOf4th * LottoPrize.RANK_4.getPrizeAmount();
        totalWinningAmount += lottoOrderResult.countOf5th * LottoPrize.RANK_5.getPrizeAmount();

        return totalWinningAmount;
    }

    public Double calculateProfitRate(LottoOrder lottoOrder, LottoOrderResult lottoOrderResult) {
        int orderPriceInWon = lottoOrder.getOrderPrice();
        int totalWinningAmount = getTotalWinningAmount(lottoOrderResult);
        return Math.round((double) totalWinningAmount / orderPriceInWon * 10 * 100) / 10.0;

    }

}
