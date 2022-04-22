package racingcar.service;

import racingcar.domain.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : choi-ys
 * @date : 2022/04/21 8:14 오후
 * 결과 판정 부는 별도의 상태값이 없도록 설계하였으므로,
 * 여러 객체의 메서드를 호출하는 하나의 트랜잭션으로 가지도록 Service Layer에 구현
 */
public class RefereeService {
    public RoundResult playSingleRound(Car car, int round) {
        RoundResult roundResult = new RoundResult(round);
        if (isMoving(car.getCarNumbers(), round)) {
            roundResult.go();
            return roundResult;
        }
        roundResult.stop();
        return roundResult;
    }

    private boolean isMoving(CarNumbers carNumbers, int round) {
        return carNumbers.getRandomNumberByRound(round) >= 4;
    }

    public CarPlayResult playAllRound(Car car, int totalRound) {
        RoundResults roundResults = new RoundResults();
        for (int i = 1; i <= totalRound; i++) {
            roundResults.addEachRoundResult(playSingleRound(car, i));
        }
        return new CarPlayResult(car, roundResults);
    }

    public PlayResult play(Cars cars, int roundCount) {
        List<CarPlayResult> carPlayResults = new ArrayList<>();
        for (Car car : cars.getCars()) {
            carPlayResults.add(playAllRound(car, roundCount));
        }
        return new PlayResult(carPlayResults);
    }
}
