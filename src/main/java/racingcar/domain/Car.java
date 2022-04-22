package racingcar.domain;

import racingcar.domain.wrap.CarName;
import racingcar.domain.wrap.CarNumbers;

/**
 * @author : choi-ys
 * @date : 2022/04/21 5:50 오후
 */
public class Car {
    private CarName carName;
    private CarNumbers carNumbers;

    public Car(String name) {
        this.carName = new CarName(name);
        this.carNumbers = new CarNumbers();
    }

    public String getCarName() {
        return carName.getName();
    }

    public void addNumber(int randomNumber) {
        carNumbers.addNumber(randomNumber);
    }

    public CarNumbers getCarNumbers() {
        return carNumbers;
    }
}
