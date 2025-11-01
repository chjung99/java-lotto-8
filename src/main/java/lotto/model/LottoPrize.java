package lotto.model;

public enum LottoPrize {
    RANK_1(2_000_000_000, "2,000,000,000원"),
    RANK_2(30_000_000,"30,000,000원"),
    RANK_3(1_500_000, "1,500,000원"),
    RANK_4(50_000, "50,000원"),
    RANK_5(5_000, "5,000원"),
    ;

    private final int prizeAmount;
    private final String prizeAmountPrompt;

    LottoPrize(int prizeAmount, String prizeAmountPrompt) {
        this.prizeAmount = prizeAmount;
        this.prizeAmountPrompt = prizeAmountPrompt;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public String getPrizeAmountPrompt() {
        return prizeAmountPrompt;
    }
}
