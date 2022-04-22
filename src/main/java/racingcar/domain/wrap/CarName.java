package racingcar.domain.wrap;

import static racingcar.constants.ErrorMessage.CAR_NAME_OVER_LENGTH_ERROR_MESSAGE;

/**
 * @author : choi-ys
 * @date : 2022/04/21 5:53 오후
 */
public class CarName {
    private String name;

    public CarName(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_OVER_LENGTH_ERROR_MESSAGE);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
