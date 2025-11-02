package lotto.model;

public class ProfitCalculator {
    public double calculateProfitRate(LottoOrder lottoOrder, int totalWinningAmount) {
        double profitRate = (double) totalWinningAmount / lottoOrder.getOrderPrice() * 100;
        return Math.round(profitRate * 10) / 10.0;
    }
}
