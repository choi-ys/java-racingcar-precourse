package racingcar.service;

import racingcar.domain.*;
import racingcar.domain.response.CarRaceResult;
import racingcar.domain.response.RoundResult;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : choi-ys
 * @date : 2022/04/23 4:53 오후
 */
public class RaceService {
    private final RandomNumberService randomNumberService;

    public RaceService(RandomNumberService randomNumberService) {
        this.randomNumberService = randomNumberService;
    }

    public CarRaceResult playSingleRoundByCar(Car car, int currentRound) {
        randomNumberService.generateSingleRoundRandomNumberByCar(car);
        if (isMoving(car, currentRound)) {
            return new CarRaceResult(car, RoundStatus.GO);
        }
        return new CarRaceResult(car, RoundStatus.STOP);
    }

    private boolean isMoving(Car car, int currentRound) {
        return car.getCarNumbers().getRandomNumberByRound(currentRound) >= 4;
    }

    public RoundResult playSingleRoundByCars(Cars cars, int currentRound) {
        List<CarRaceResult> carRaceResults = new ArrayList<>();
        for (Car car : cars.getCars()) {
            carRaceResults.add(playSingleRoundByCar(car, currentRound));
        }
        return RoundResult.of(currentRound, carRaceResults);
    }
}
