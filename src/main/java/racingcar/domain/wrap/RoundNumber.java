package racingcar.domain.wrap;

import static racingcar.constants.ErrorMessage.INVALID_ROUND_NUMBER_BOUNDARY_ERROR_MESSAGE;

/**
 * @author : choi-ys
 * @date : 2022-04-24 오후 8:58
 */
public class RoundNumber {
    int currentRound;
    public static final int MINIMUM_ROUND_NUMBER = 1;

    public RoundNumber(int currentRound) {
        if (currentRound < 1) {
            throw new IllegalArgumentException(INVALID_ROUND_NUMBER_BOUNDARY_ERROR_MESSAGE);
        }
        this.currentRound = currentRound;
    }

    public int getCurrentRound() {
        return currentRound;
    }
}
