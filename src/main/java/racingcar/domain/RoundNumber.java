package racingcar.domain;

/**
 * @author : choi-ys
 * @date : 2022/04/21 8:21 오후
 */
public class RoundNumber {
    private int round;

    public RoundNumber(int round) {
        if (round < 1) {
            throw new IllegalArgumentException("라운드는 1보다 작을 수 없습니다.");
        }
        this.round = round;
    }

    public int getRound() {
        return round;
    }
}
