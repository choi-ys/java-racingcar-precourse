package racingcar.domain;

import java.util.List;

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

    public List<Integer> getNumbers() {
        return this.carNumbers.getNumbers();
    }
}
