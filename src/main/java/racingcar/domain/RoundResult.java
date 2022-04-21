package racingcar.domain;

/**
 * @author : choi-ys
 * @date : 2022/04/21 8:15 오후
 */
public class RoundResult {
    private RoundNumber roundNumber;
    private RoundStatus roundStatus;

    public int getRound() {
        return roundNumber.getRound();
    }

    public RoundStatus getRoundStatus() {
        return roundStatus;
    }

    public RoundResult(int round) {
        this.roundNumber = new RoundNumber(round);
    }

    public void go() {
        roundStatus = RoundStatus.GO;
    }

    public void stop() {
        roundStatus = RoundStatus.STOP;
    }
}
