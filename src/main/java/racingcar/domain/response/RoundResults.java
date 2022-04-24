package racingcar.domain.response;

import java.util.List;

/**
 * @author : choi-ys
 * @date : 2022-04-25 오전 12:02
 */
public class RoundResults {
    private List<RoundResult> roundResults;

    public RoundResults(List<RoundResult> roundResults) {
        this.roundResults = roundResults;
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }
}
