package lotto.util;

public class InputValidator {
    public static int parseAmount(String inputAmount) {
        try {
            return Integer.parseInt(inputAmount);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력하세요");
        }
    }

    public static void validateAmountUnit(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위의 양수여야 합니다");
        }
    }

    public static int validatePurchaseAmountInWon(String inputAmount) {
        int amount = parseAmount(inputAmount);
        validateAmountUnit(amount);
        return amount;
    }
}
