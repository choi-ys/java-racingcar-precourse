package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : choi-ys
 * @date : 2022/04/21 3:26 오후
 */
@DisplayName("플레이어 Test")
public class CarsTest {

    private final String names = "람보르기니,마카롱택시,카카오택시,온다 택시";
    private Cars cars;

    @BeforeEach
    public void setUp() {
        cars = Cars.of(names);
    }

    @Test
    @DisplayName("자동자 이름 입력 Test")
    public void 자동자_이름_입력_및_분리_Test() {
        // Then
        assertThat(cars.getCarNames().length).isEqualTo(names.split(",").length);
    }

    // TODO : 도메인 안쪽에 위치한 Random 로직으로 인해 통제변인 고정이 어려워 의도한대로 동작하는지 확인이 어려움
    @Test
    @DisplayName("하나의 라운드 진행 Test")
    public void 하나의_라운드_진행_Test() {
        // When
        cars.progressRound();

        // Then
        cars.getCurrentMovingStatus();
    }

    // TODO : 도메인 안쪽에 위치한 Random 로직으로 인해 통제변인 고정이 어려워 의도한대로 동작하는지 확인이 어려움
    @Test
    @DisplayName("입력받은 회차만큼 라운드 진행 Test")
    public void 입력받은_회차만큼_라운드_진행_Test() {
        // Given
        int given = 5;

        // When
        cars.gameStart(given);

        // Then
        cars.getCurrentMovingStatus();
    }
}
