package racingcar.domain.response;

import racingcar.domain.wrap.RoundNumber;

import java.util.List;

/**
 * @author : choi-ys
 * @date : 2022-04-24 오후 1:36
 */
public class RoundResult {
    private RoundNumber roundNumber;
    private CarRaceResults carRaceResults;

    private RoundResult(RoundNumber roundNumber, CarRaceResults carRaceResults) {
        this.roundNumber = roundNumber;
        this.carRaceResults = carRaceResults;
    }

    public static RoundResult of(int currentRound, List<CarRaceResult> carRaceResults) {
        return new RoundResult(new RoundNumber(currentRound), new CarRaceResults(carRaceResults));
    }

    public int getCurrentRound() {
        return roundNumber.getCurrentRound();
    }

    public List<CarRaceResult> getRaceResults() {
        return carRaceResults.getCarRaceResults();
    }
}
