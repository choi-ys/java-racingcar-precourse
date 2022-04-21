package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : choi-ys
 * @date : 2022/04/21 5:50 오후
 */
public class Car {
    private CarName carName;
    private List<Integer> numbers = new ArrayList<>();

    public Car(String name) {
        this.carName = new CarName(name);
    }

    public void addNumber(int randomNumber) {
        this.numbers.add(randomNumber);
    }

    public String getCarName() {
        return carName.getName();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
