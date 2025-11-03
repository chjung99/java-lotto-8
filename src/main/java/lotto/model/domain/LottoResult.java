package lotto.model.domain;

public class LottoResult {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public LottoResult(Lotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
