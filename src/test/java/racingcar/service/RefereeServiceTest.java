package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RoundResult;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : choi-ys
 * @date : 2022/04/21 8:17 오후
 */
class RefereeServiceTest {

    @Test
    @DisplayName("한 라운드 Play 결과 Test")
    public void playSingleRoundResultTest() {
        // Given
        String name = "마카롱택시";
        Car car = new Car(name);
        int randomNumber = 1;
        car.addNumber(randomNumber);
        int round = 1;

        RefereeService refereeService = new RefereeService();

        // When
        RoundResult roundResult = refereeService.playSingleRound(car, round);

        // Then
        assertThat(roundResult.getCar().getCarNumbers().getRandomNumberByRound(round)).isEqualTo(randomNumber);
        assertThat(roundResult.getRound()).isEqualTo(round);
        assertThat(roundResult.getRoundStatus().isStop()).isTrue();
    }
}