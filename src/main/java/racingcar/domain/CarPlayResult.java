package racingcar.domain;

import java.util.List;

/**
 * @author : choi-ys
 * @date : 2022/04/21 8:15 오후
 */
public class CarPlayResult {
    private Car car;
    private RoundResults roundResults;

    public CarPlayResult(Car car, RoundResults roundResults) {
        this.car = car;
        this.roundResults = roundResults;
    }

    public Car getCar() {
        return car;
    }

    public List<RoundResult> getRoundResults() {
        return roundResults.getRoundResults();
    }

    public int getScore() {
        return roundResults.roundResultToScore();
    }
}
