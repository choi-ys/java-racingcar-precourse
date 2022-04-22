package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : choi-ys
 * @date : 2022/04/22 11:25 오전
 */
public class Player {
    private List<String> carNames;
    private int roundCount;

    public Player(List<String> carNames, int roundCount) {
        this.carNames = carNames;
        this.roundCount = roundCount;
    }

    public static Player of(String namesByComma, int roundCount) {
        String[] strings = splitByComma(namesByComma);
        List<String> carNames = new ArrayList<>(Arrays.asList(strings));
        return new Player(carNames, roundCount);
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getRoundCount() {
        return roundCount;
    }

    private static String[] splitByComma(String namesByComma) {
        return namesByComma.split(",");
    }
}
