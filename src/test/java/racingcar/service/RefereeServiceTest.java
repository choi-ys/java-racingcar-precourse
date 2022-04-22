package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.*;

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

    private String carName = "우티";
    private Car car;

    private String namesByComma = "람보르기니,마카롱택시,카카오택시,우라칸,밀레";
    private int roundCount = 5;
    private Player player;
    private Cars cars;

    private RefereeService refereeService;

    @BeforeEach
    void setUp() {
        car = new Car(carName);
        player = Player.of(namesByComma, roundCount);
        cars = Cars.of(player);

        refereeService = new RefereeService();
    }

    @Test
    @DisplayName("단일 Car 객체의 단일 라운드 Play 결과 Test")
    public void singleCarPlaySingleRoundResultTest() {
        // Given
        int randomNumber = 1;
        car.addNumber(randomNumber);
        int round = 1;

        // When
        RoundResult roundResult = refereeService.playSingleRound(car, round);

        // Then
        assertThat(roundResult.getRound()).as("현재 라운드의 수행 결과 여부 검증").isEqualTo(round);
        assertThat(roundResult.getRoundStatus().isStop()).as("라운드 수행 결과 검증").isTrue();
    }

    @Test
    @DisplayName("단일 Car 객체의 전체 라운드 Play 결과 Test")
    public void singleCarPlayAllRoundResultTest() {
        // Given
        int gameCount = 5;
        List<Integer> randomNumbers = Arrays.asList(1, 2, 3, 4, 5);
        for (Integer randomNumber : randomNumbers) {
            car.addNumber(randomNumber);
        }

        // When
        CarPlayResult carPlayResult = refereeService.playAllRound(car, gameCount);


        // Then
        List<RoundResult> actual = carPlayResult.getRoundResults();
        assertAll(
                () -> assertThat(car.getCarNumbers().getNumbers().containsAll(randomNumbers)),
                () -> assertThat(carPlayResult.getCar()).isEqualTo(car),
                () -> assertThat(actual.size()).isEqualTo(gameCount),
                () -> assertThat(actual.get(gameCount - 1).getRound()).isEqualTo(gameCount),
                () -> assertThat(actual.get(0).getRoundStatus().isStop()).as("1 라운드 진행 결과").isTrue(),
                () -> assertThat(actual.get(1).getRoundStatus().isStop()).as("2 라운드 진행 결과").isTrue(),
                () -> assertThat(actual.get(2).getRoundStatus().isStop()).as("3 라운드 진행 결과").isTrue(),
                () -> assertThat(actual.get(3).getRoundStatus().isGo()).as("4 라운드 진행 결과").isTrue(),
                () -> assertThat(actual.get(4).getRoundStatus().isGo()).as("5 라운드 진행 결과").isTrue(),
                () -> assertThat(carPlayResult.getScore()).as("전체 라운드 진행 결과를 점수로 환산").isEqualTo(2)
        );
    }

    @Test
    @DisplayName("전체 Car 객체의 전체 라운드 Play 결과 Test : 단독 우승")
    public void playSingleWinner() {
        // Given
        List<Integer> randomNumbers = Arrays.asList(1, 2, 3, 4, 5);
        for (Integer randomNumber : randomNumbers) {
            cars.getCarByIndex(0).addNumber(randomNumber);
            cars.getCarByIndex(1).addNumber(randomNumber);
            cars.getCarByIndex(3).addNumber(randomNumber);
            cars.getCarByIndex(4).addNumber(randomNumber);
        }
        List<Integer> winnersRandomNumbers = Arrays.asList(1, 2, 4, 4, 5);
        for (Integer randomNumber : winnersRandomNumbers) {
            cars.getCarByIndex(2).addNumber(randomNumber);
        }

        // When
        PlayResult playResult = refereeService.play(cars, roundCount);

        // Then
        assertThat(playResult.findWinner()).isEqualTo(cars.getCarByIndex(2).getCarName());
        assertThat(playResult.getCarPlayResults()).size().isEqualTo(cars.getCarsSize());
        assertThat(playResult.getCarPlayResults().get(0).getRoundResults()).size().isEqualTo(roundCount);
    }

    @Test
    @DisplayName("전체 Car 객체의 전체 라운드 Play 결과 Test : 공동 우승")
    public void playJointWinner() {
        // Given
        List<Integer> randomNumbers = Arrays.asList(1, 2, 3, 4, 5);
        for (Integer randomNumber : randomNumbers) {
            cars.getCarByIndex(0).addNumber(randomNumber);
            cars.getCarByIndex(2).addNumber(randomNumber);
            cars.getCarByIndex(4).addNumber(randomNumber);
        }
        List<Integer> winnersRandomNumbers = Arrays.asList(1, 2, 4, 4, 5);
        for (Integer randomNumber : winnersRandomNumbers) {
            cars.getCarByIndex(1).addNumber(randomNumber);
            cars.getCarByIndex(3).addNumber(randomNumber);
        }

        // When
        PlayResult playResult = refereeService.play(cars, roundCount);

        // Then
        List<CarPlayResult> carPlayResults = playResult.getCarPlayResults();

        String firstWinnerCarName = cars.getCarByIndex(1).getCarName();
        String secondWinnerCarName = cars.getCarByIndex(3).getCarName();
        String winnerNames = firstWinnerCarName.concat(",").concat(secondWinnerCarName);

        assertThat(playResult.findWinner()).isEqualTo(winnerNames);
        assertThat(carPlayResults).size().isEqualTo(cars.getCarsSize());
        assertThat(carPlayResults.get(0).getRoundResults()).size().isEqualTo(roundCount);
    }
}