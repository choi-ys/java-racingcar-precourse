package racingcar.domain;

/**
 * @author : choi-ys
 * @date : 2022/04/21 7:33 오후
 */
public enum RoundStatus {
    GO, STOP;

    public boolean isGo() {
        return this == GO;
    }

    public boolean isStop() {
        return this == STOP;
    }
}
