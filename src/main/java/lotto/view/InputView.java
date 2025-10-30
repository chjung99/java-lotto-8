package lotto.view;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

    public String getPurchaseAmountInWon() {
        System.out.println(InputViewMessage.INPUT_PURCHASE_PRICE_PROMPT);
        return readLine();
    }
}
