package lotto.model.domain;

public class BonusNumber {
    private final Lotto winnigLotto;
    private final int value;

    public BonusNumber(int value, Lotto winnigLotto) {
        validate(value, winnigLotto);
        this.value = value;
        this.winnigLotto = winnigLotto;
    }

    private void validate(int value, Lotto winnigLotto) {
        if (value < 1 || value > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winnigLotto.getNumbers().contains(value)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
