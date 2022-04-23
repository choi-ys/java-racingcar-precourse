package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import static racingcar.domain.wrap.CarNumbers.END_NUMBER;
import static racingcar.domain.wrap.CarNumbers.START_NUMBER;

/**
 * @author : choi-ys
 * @date : 2022/04/22 12:55 오후
 */
public class RandomNumberService {
    public void generateSingleRoundRandomNumberCar(Car car) {
        car.addNumber(Randoms.pickNumberInRange(START_NUMBER, END_NUMBER));
    }

    public void generateSingleRoundRandomNumberCar(Cars cars) {
        for (Car car : cars.getCars()) {
            generateSingleRoundRandomNumberCar(car);
        }
    }
}
