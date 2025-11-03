package lotto.model.service;

import lotto.model.domain.LottoResult;

public interface WinningNumberProvider {
    LottoResult provide();
}
