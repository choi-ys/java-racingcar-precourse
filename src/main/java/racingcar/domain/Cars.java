package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : choi-ys
 * @date : 2022/04/21 10:28 오후
 */
public class Cars {
    List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(Player player) {
        List<String> carNames = player.getCarNames();
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    public Car getCarByIndex(int index) {
        return cars.get(index);
    }
}
