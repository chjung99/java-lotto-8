package lotto.model.service;

import lotto.model.domain.LottoResult;
import lotto.model.domain.BonusNumber;
import lotto.model.domain.Lotto;

public class UserInputWinningNumberProvider implements WinningNumberProvider {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public UserInputWinningNumberProvider(Lotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    @Override
    public LottoResult provide() {
        return new LottoResult(winningLotto, bonusNumber);
    }
}
