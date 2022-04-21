package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : choi-ys
 * @date : 2022/04/21 3:40 오후
 */
public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(String names) {
        List<Car> cars = new ArrayList<>();
        for (String name : splitNames(names)) {
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }

    public String[] getCarNames() {
        String[] temp = new String[cars.size()];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = cars.get(i).getName();
        }
        return temp;
    }

    public void progressRound() {
        for (Car car : cars) {
            car.generateRandomNumber();
        }
    }

    public void gameStart(int gameRound) {
        for (int i = 0; i < gameRound; i++) {
            progressRound();
        }
    }

    public void getCurrentMovingStatus() {
        for (Car car : cars) {
            System.out.println(car.getName().concat(" : ").concat(car.getProgress()));
        }
    }

    private static String[] splitNames(String names) {
        return names.split(",");
    }
}
