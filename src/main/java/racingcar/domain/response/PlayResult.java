package racingcar.domain.response;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : choi-ys
 * @date : 2022-04-24 오후 11:26
 */
public class PlayResult {
    private Cars Cars;
    private Winners winners;

    public PlayResult(Cars cars) {
        this.Cars = cars;
        this.winners = getWinners();
    }

    public Winners getWinners() {
        int winnerScore = getWinnerScore();
        List<Car> winnerCars = new ArrayList<>();
        for (Car car : Cars.getCars()) {
            addWinner(winnerCars, car, winnerScore);
        }
        return new Winners(winnerCars);
    }

    private int getWinnerScore() {
        int winnerScore = 0;
        for (Car car : Cars.getCars()) {
            winnerScore = updateWinnerScore(car, winnerScore);
        }
        return winnerScore;
    }

    private int updateWinnerScore(Car car, int winnerScore) {
        return Math.max(car.getScore(), winnerScore);
    }

    private void addWinner(List<Car> winnerCars, Car car, int winnerScore) {
        if (car.getScore() > winnerScore) {
            winnerCars.clear();
            winnerCars.add(car);
            return;
        }
        if (car.getScore() == winnerScore) {
            winnerCars.add(car);
        }
    }
}
