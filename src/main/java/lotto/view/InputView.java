package lotto.view;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {
    private final String INPUT_PURCHASE_PRICE_PROMPT = "구입금액을 입력해 주세요.";

    public String getPurchaseAmountInWon() {
        System.out.println(INPUT_PURCHASE_PRICE_PROMPT);
        return readLine();
    }
}
