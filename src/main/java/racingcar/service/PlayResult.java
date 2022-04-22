package racingcar.service;

import racingcar.domain.CarPlayResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : choi-ys
 * @date : 2022/04/22 2:03 오후
 */
public class PlayResult {
    List<CarPlayResult> carPlayResults;

    public PlayResult(List<CarPlayResult> carPlayResults) {
        this.carPlayResults = carPlayResults;
    }

    public List<CarPlayResult> getCarPlayResults() {
        return carPlayResults;
    }

    public String findWinner() {
        return returnWinnerNames();
    }

    private String returnWinnerNames() {
        return getWinnerNames(getWinnerScore());
    }

    private String getWinnerNames(int winnerScore) {
        List<String> winnerNames = new ArrayList<>();
        for (CarPlayResult carPlayResult : carPlayResults) {
            addWinner(winnerScore, winnerNames, carPlayResult);
        }
        return winnerNamesJoining(winnerNames);
    }

    private void addWinner(int winnerScore, List<String> winnerNames, CarPlayResult carPlayResult) {
        if (carPlayResult.getScore() == winnerScore) {
            winnerNames.add(carPlayResult.getCar().getCarName());
        }
    }

    private String winnerNamesJoining(List<String> winnerNames) {
        return String.join(",", winnerNames);
    }

    private int getWinnerScore() {
        List<Integer> scores = new ArrayList<>();
        for (CarPlayResult carPlayResult : carPlayResults) {
            scores.add(carPlayResult.getScore());
        }
        return Collections.max(scores);
    }
}
