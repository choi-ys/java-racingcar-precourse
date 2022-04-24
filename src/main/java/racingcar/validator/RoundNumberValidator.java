package racingcar.validator;

import racingcar.domain.wrap.RoundNumber;

import static racingcar.constants.ErrorMessage.INVALID_ROUND_NUMBER_TYPE_MESSAGE;

/**
 * @author : choi-ys
 * @date : 2022-04-25 오전 1:20
 */
public class RoundNumberValidator {
    public static boolean isValidRoundNumber(String totalRound) {
        return isValidType(totalRound) && isValidNumber(Integer.parseInt(totalRound));
    }

    private static boolean isValidType(String totalRound) {
        try {
            isNumber(totalRound);
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void isNumber(String totalRound) {
        try {
            Integer.parseInt(totalRound);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INVALID_ROUND_NUMBER_TYPE_MESSAGE);
        }
    }

    private static boolean isValidNumber(int totalRound) {
        try {
            new RoundNumber(totalRound);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }
}
