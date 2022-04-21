package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : choi-ys
 * @date : 2022/04/21 8:15 오후
 */
public class RoundResults {
    List<RoundResult> roundResults = new ArrayList<>();

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }

    public void addSingleRoundResult(RoundResult roundResult) {
        roundResults.add(roundResult);
    }
}
