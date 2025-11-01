package lotto.view;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {
    private final String INPUT_PURCHASE_PRICE_PROMPT = "구입금액을 입력해 주세요.";
    private final String INPUT_WINNING_NUMBER_PROMPT = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    public String getPurchaseAmountInWon() {
        System.out.println(INPUT_PURCHASE_PRICE_PROMPT);
        return readLine();
    }

    public String getWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_PROMPT);
        return readLine();
    }

    public String getBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_PROMPT);
        return readLine();
    }
}
