package racingcar.validator;

import racingcar.domain.wrap.CarName;
import racingcar.utils.CarNamesUtils;

import static racingcar.constants.ErrorMessage.INVALID_CAR_COUNT_MESSAGE;
import static racingcar.constants.ErrorMessage.INVALID_SEPARATOR_MESSAGE;
import static racingcar.utils.CarNamesUtils.SEPARATOR;

/**
 * @author : choi-ys
 * @date : 2022-04-25 오전 1:20
 */
public class CarNamesValidator {
    public static final int MINIMUM_CAR_COUNT = 2;

    public static boolean isValidNames(String namesByComma) {
        if (!namesByComma.contains(SEPARATOR)) {
            System.out.println(INVALID_SEPARATOR_MESSAGE);
            return false;
        }
        if (!(CarNamesUtils.splitByComma(namesByComma).length > MINIMUM_CAR_COUNT)) {
            System.out.println(INVALID_CAR_COUNT_MESSAGE);
            return false;
        }
        return true;
    }

    public static Boolean isValidName(String name) {
        try {
            new CarName(name);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
