package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.constants.ErrorMessage.NAME_LENGTH_OVER_MESSAGE;
import static racingcar.constants.GameConstants.*;

/**
 * @author : choi-ys
 * @date : 2022/04/20 8:34 오후
 */
public class Car {
    private String name;
    private int randomValue = 0;
    private String progress = "";

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_OVER_MESSAGE);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getRandomValue() {
        return randomValue;
    }

    public String getProgress() {
        return progress;
    }

    public void generateRandomNumber() {
        this.randomValue = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
        checkProgress();
    }

    private void checkProgress() {
        if (isMove()) {
            progress += PROGRESS;
        }
    }

    private boolean isMove() {
        return randomValue >= MOVE_CONDITION;
    }
}
