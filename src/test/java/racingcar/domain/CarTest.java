package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;
import static racingcar.constants.ErrorMessage.NAME_LENGTH_OVER_MESSAGE;
import static racingcar.constants.GameConstants.*;

/**
 * @author : choi-ys
 * @date : 2022/04/20 8:34 오후
 */
@DisplayName("자동차 객체 Test")
class CarTest {

    Car car;
    String given = "마카롱택시";

    @BeforeEach
    public void setUp() {
        car = new Car(given);
    }

    @Test
    @DisplayName("자동차 이름이 5글자 이상인 경우 예외 처리 Test")
    void carNameLengthExceptionTest() {
        // Given
        String given = "람보르기니 우라칸";

        // When & Then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(given))
                .withMessageContaining(NAME_LENGTH_OVER_MESSAGE);
    }

    @Test
    @DisplayName("5글자 이하의 이름을 가지는 자동차 객체 생성 Test")
    void generateCarTest() {
        // Then
        assertAll(
                () -> assertThat(car).isNotNull(),
                () -> assertThat(car.getName().length()).isBetween(1, 5),
                () -> assertThat(car.getName()).isEqualTo(given)
        );
    }

    @Test
    @DisplayName("1~9 범위내의 자동차 객체 난수 생성")
    public void generateCarRandomNumberTest() {
        // When
        car.generateRandomNumber();

        // Then
        assertThat(car.getRandomValue()).isBetween(MIN_VALUE, MAX_VALUE);
    }


    // TODO : 난수에 따라 결정되는 값에 대한 TC는 어떻게 작성 해야할까..?
    // TODO : 난수 생성 부를 Car Class 에서 분리 할 수 있는지 여부를 고민해보자
    @Test
    @DisplayName("자동차의 현재 난수에 따른 진행도 누적 부 구현")
    public void generateCarTest2() {
        // When
        car.generateRandomNumber();

        // Then
        if (car.getRandomValue() >= MOVE_CONDITION) {
            assertThat(car.getProgress()).isEqualTo(PROGRESS);
            return;
        }
        assertThat(car.getProgress()).isEmpty();
    }

    // TODO : 해당 TC도 위의 TC와 마찬가지로 Random 처리부가 Car에 있어서 제대로 된 TC 작성이 어려운 부분을 고민해보자
    // TODO : 게임 차수를 입력받은 후 해당 차수만큼 난수를 발생시키므로, 외부에서 배열로 생성한 난수를 Car에 할당하면 어떨까?
    // TODO : 난수 생성부가 Car에 종속적이어야 하는지 고민해보고 분리한 후 TC를 리팩터링 해보자
    @Test
    @DisplayName("게임 차수에 따른 진행도 누적 Test")
    public void givenGameCount_whenGenerateCarNumber_thenCheckProgressIsAccumulated() {
        // Given
        int gameCount = 5;
        List<Integer> generatedRandomNumbers = new ArrayList<>();
        int movingCount = 0;

        // When
        for (int i = 0; i < gameCount; i++) {
            car.generateRandomNumber();
            generatedRandomNumbers.add(car.getRandomValue());
        }

        for (int randomNumber : generatedRandomNumbers) {
            movingCount += isMoving(randomNumber);
        }

        // Then
        assertThat(car.getProgress().length()).isEqualTo(movingCount);
    }

    private int isMoving(int randomNumber) {
        return randomNumber >= MOVE_CONDITION ? 1 : 0;
    }
}
