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

    public static Cars of(String namesByComma) {
        String[] strings = splitByComma(namesByComma);
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            cars.add(new Car(strings[i]));
        }
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public Car getCarByIndex(int index) {
        return cars.get(index);
    }

    private static String[] splitByComma(String namesByComma) {
        return namesByComma.split(",");
    }

}
