package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.CarRaceResult;
import racingcar.domain.RoundStatus;

/**
 * @author : choi-ys
 * @date : 2022/04/23 4:53 오후
 */
public class RaceService {
    private final RandomNumberService randomNumberService;

    public RaceService(RandomNumberService randomNumberService) {
        this.randomNumberService = randomNumberService;
    }

    public CarRaceResult playEachCarSingleRound(Car car, int currentRound) {
        randomNumberService.generateSingleRoundRandomNumber(car);
        if (isMoving(car, currentRound)) {
            return new CarRaceResult(car, RoundStatus.GO);
        }
        return new CarRaceResult(car, RoundStatus.STOP);
    }

    private boolean isMoving(Car car, int currentRound) {
        return car.getCarNumbers().getRandomNumberByRound(currentRound) >= 4;
    }
}
