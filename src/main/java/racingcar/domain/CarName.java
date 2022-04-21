package racingcar.domain;

/**
 * @author : choi-ys
 * @date : 2022/04/21 5:53 오후
 */
public class CarName {
    private String name;

    public CarName(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 1~5자의 이름을 입력하세요");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
