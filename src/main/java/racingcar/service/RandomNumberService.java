package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Cars;

/**
 * @author : choi-ys
 * @date : 2022/04/22 12:55 오후
 */
public class RandomNumberService {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 9;

    public void generateRandomNumberForSingleRound(Cars cars) {
        for (Car car : cars.getCars()) {
            car.addNumber(Randoms.pickNumberInRange(START_NUMBER, END_NUMBER));
        }
    }

    public void generateRandomNumberForAllRound(Cars cars, int roundCount) {
        for (int i = 1; i <= roundCount; i++) {
            generateRandomNumberForSingleRound(cars);
        }
    }
}
