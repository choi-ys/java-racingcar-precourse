package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.CarNumbers;
import racingcar.domain.RoundResult;

/**
 * @author : choi-ys
 * @date : 2022/04/21 8:14 오후
 * 레프리는 유지해야하는 상태값이 없어도 되도록 설계했으므로, 여러객체의 메서드를 호출하는것을 하나의 트랜잭션으로 가지도록 Service Layer 구현
 */
public class RefereeService {

    public RoundResult playSingleRound(Car car, int round) {
        RoundResult roundResult = new RoundResult(car, round);
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
}
