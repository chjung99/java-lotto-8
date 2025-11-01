package lotto.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static int parseNaturalNumber(String input) {
        try {
            return Integer.parseUnsignedInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력하세요");
        }
    }

    public static List<Integer> parseStringToListOfInteger(String[] inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        try {
            for (String input : inputNumbers) {
                numbers.add(parseNaturalNumber(input));
            }
            return numbers;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력하세요");
        }
    }

    public static String[] parseStringToStringArray(String input) {
        String[] inputNumbers = input.split(",");
        if (inputNumbers.length == 1) {
            throw new IllegalArgumentException("구분자는 ',' 이어야 합니다");
        }
        return inputNumbers;
    }

    public static void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()){
            throw new IllegalArgumentException("중복된 숫자가 입력되었습니다.");
        }
    }

    public static void validateCountOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6){
            throw new IllegalArgumentException("6개의 숫자가 입력되어야 합니다.");
        }
    }

    public static void validateRangeOfNumber(int number){
        if (number<1 || number >45){
            throw new IllegalArgumentException("입력된 숫자는 1에서 45사이어야 합니다.");
        }
    }

    public static void validateRangeOfNumbers(List<Integer> numbers){
        for (int number: numbers){
            validateRangeOfNumber(number);
        }
    }

    public static List<Integer> parseWinningNumbers(String inputWinningNumber) {
        // 입력 형식 체크 (,으로 구분되는 지)
        String[] inputNumbers = parseStringToStringArray(inputWinningNumber);

        // 입력 형식 체크 (전부 숫자 인지)
        List<Integer> numbers = parseStringToListOfInteger(inputNumbers);

        // 개수 체크
        validateCountOfNumbers(numbers);

        // 중복 체크
        validateDuplicatedNumber(numbers);

        // 범위 체크 (1~45)
        validateRangeOfNumbers(numbers);

        return numbers;
    }

    public static int parseBonusNumber(String inputBonusNumber) {
        int bonusNumber = parseNaturalNumber(inputBonusNumber);
        validateRangeOfNumber(bonusNumber);
        return bonusNumber;
    }
}
