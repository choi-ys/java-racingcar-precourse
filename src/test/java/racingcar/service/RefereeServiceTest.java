package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RoundResult;
import racingcar.domain.RoundResults;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * @author : choi-ys
 * @date : 2022/04/21 8:17 오후
 */
@DisplayName("결과 판정")
class RefereeServiceTest {

    private String carName = "마카롱택시";
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(carName);
    }

    @Test
    @DisplayName("단일 Car 객체의 단일 라운드 Play 결과 Test")
    public void playSingleRoundResultTest() {
        // Given
        int randomNumber = 1;
        car.addNumber(randomNumber);
        int round = 1;

        RefereeService refereeService = new RefereeService();

        // When
        RoundResult roundResult = refereeService.playSingleRound(car, round);

        // Then
        assertThat(roundResult.getCar().getCarNumbers().getRandomNumberByRound(round)).isEqualTo(randomNumber);
        assertThat(roundResult.getRound()).as("현재 라운드의 수행 결과 여부 검증").isEqualTo(round);
        assertThat(roundResult.getRoundStatus().isStop()).as("라운드 수행 결과 검증").isTrue();
    }

    @Test
    @DisplayName("단일 Car 객체의 전체 라운드 Play 결과 Test")
    public void playAllRoundResultTest() {
        // Given
        int gameCount = 5;
        List<Integer> randomNumbers = Arrays.asList(1, 2, 3, 4, 5);
        for (int i = 0; i < randomNumbers.size(); i++) {
            car.addNumber(randomNumbers.get(i));
        }

        RefereeService refereeService = new RefereeService();

        // When
        RoundResults roundResults = refereeService.play(car, gameCount);

        // Then
        List<RoundResult> actual = roundResults.getRoundResults();
        assertAll(
                () -> assertThat(car.getCarNumbers().getNumbers().containsAll(randomNumbers)),
                () -> assertThat(actual.get(0).getCar()).isEqualTo(car),
                () -> assertThat(actual.size()).isEqualTo(gameCount),
                () -> assertThat(actual.get(gameCount - 1).getRound()).isEqualTo(gameCount),
                () -> assertThat(actual.get(0).getRoundStatus().isStop()).as("1 라운드 진행 결과").isTrue(),
                () -> assertThat(actual.get(1).getRoundStatus().isStop()).as("2 라운드 진행 결과").isTrue(),
                () -> assertThat(actual.get(2).getRoundStatus().isStop()).as("3 라운드 진행 결과").isTrue(),
                () -> assertThat(actual.get(3).getRoundStatus().isGo()).as("4 라운드 진행 결과").isTrue(),
                () -> assertThat(actual.get(4).getRoundStatus().isGo()).as("5 라운드 진행 결과").isTrue()
        );
    }
}