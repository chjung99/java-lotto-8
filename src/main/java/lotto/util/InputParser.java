package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    public static int parseNaturalNumber(String input) {
        try {
            return Integer.parseUnsignedInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 입력 형식이 잘못되었습니다.");
        }
    }

    private static String[] splitByComma(String input) {
        return input.trim().split(",");
    }

    public static List<Integer> parseNaturalNumberList(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] tokens = splitByComma(input);

        for (String token : tokens) {
            numbers.add(parseNaturalNumber(token));
        }

        return numbers;

    }
}
