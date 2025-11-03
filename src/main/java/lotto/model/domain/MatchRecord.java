package lotto.model.domain;

import java.util.Objects;

public class MatchRecord {
    private int matchCount;
    private boolean isContainBonusNumber;

    public MatchRecord(int matchCount, boolean isContainBonusNumber) {
        this.matchCount = matchCount;
        this.isContainBonusNumber = isContainBonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MatchRecord that = (MatchRecord) o;
        return matchCount == that.matchCount && isContainBonusNumber == that.isContainBonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, isContainBonusNumber);
    }
}
