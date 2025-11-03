package lotto.model.domain;

public class BonusNumber {
    private final int value;

    public BonusNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < 1 || value > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
