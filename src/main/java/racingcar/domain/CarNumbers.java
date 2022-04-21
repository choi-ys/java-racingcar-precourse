package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : choi-ys
 * @date : 2022/04/21 7:12 오후
 */
public class CarNumbers {
    private List<Integer> numbers = new ArrayList<>();

    void addNumber(int randomNumber) {
        if (randomNumber < 1 || randomNumber > 9) {
            throw new IllegalArgumentException("[ERROR] 1~9사이의 숫자만 가능합니다.");
        }
        this.numbers.add(randomNumber);
    }

    List<Integer> getNumbers() {
        return numbers;
    }
}
