package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.*;
import racingcar.domain.response.CarRaceResult;
import racingcar.domain.response.RoundResult;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * @author : choi-ys
 * @date : 2022/04/23 4:53 오후
 */
@DisplayName("Service:Race")
class RaceServiceTest {

    private final String name = "마카롱택시";
    int currentRound = 1;
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(name);
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("단일 차량의 단일 라운드 진행 Test : 전진")
    public void playSingleRound_andAssertionsGoTest(int randomNumber) {
        // Given
        car.addNumber(randomNumber);

        // When
        RaceService raceService = new RaceService(new RandomNumberService());
        CarRaceResult carRaceResult = raceService.playSingleRoundByCar(car, currentRound);

        // Then
        assertThat(carRaceResult.getCar()).isEqualTo(car);
        assertThat(carRaceResult.getRoundStatus().isGo()).isTrue();
    }

    private static Stream playSingleRound_andAssertionsGoTest() {
        return Stream.of(
                Arguments.of(4),
                Arguments.of(9)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("단일 차량의 단일 라운드 진행 Test : 멈춤")
    public void playSingleRound_andAssertionsStopTest(int randomNumber) {
        // Given
        car.addNumber(randomNumber);

        // When
        RaceService raceService = new RaceService(new RandomNumberService());
        CarRaceResult carRaceResult = raceService.playSingleRoundByCar(car, currentRound);

        // Then
        assertThat(carRaceResult.getCar()).isEqualTo(car);
        assertThat(carRaceResult.getRoundStatus().isStop()).isTrue();
    }

    private static Stream playSingleRound_andAssertionsStopTest() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(3)
        );
    }

    @Test
    @DisplayName("전체 차량의 단일 라운드 진행 Test")
    public void playSingleRoundByCars_andAssertionsResultTest() {
        // Given
        String namesByComma = "람보르기니,마카롱택시,카카오택시,우라칸,밀레";
        int roundCount = 5;
        Player player = Player.of(namesByComma, roundCount);
        Cars cars = Cars.of(player);

        cars.getCarByIndex(0).addNumber(1);
        cars.getCarByIndex(1).addNumber(2);
        cars.getCarByIndex(2).addNumber(3);
        cars.getCarByIndex(3).addNumber(4);
        cars.getCarByIndex(4).addNumber(5);

        RaceService raceService = new RaceService(new RandomNumberService());

        // When
        RoundResult roundResult = raceService.playSingleRoundByCars(cars, 1);

        // Then
        List<CarRaceResult> raceResults = roundResult.getRaceResults();
        assertAll(
                () -> assertThat(roundResult.getCurrentRound()).isEqualTo(1),
                () -> assertThat(raceResults.get(0).getRoundStatus().isStop()).isTrue(),
                () -> assertThat(raceResults.get(1).getRoundStatus().isStop()).isTrue(),
                () -> assertThat(raceResults.get(2).getRoundStatus().isStop()).isTrue(),
                () -> assertThat(raceResults.get(3).getRoundStatus().isGo()).isTrue(),
                () -> assertThat(raceResults.get(4).getRoundStatus().isGo()).isTrue()
        );
    }

    // TODO : 전체 차량의 단일 라운드 진행 및 결과 검증 Test
    // TODO : 전체 차량의 전체 라운드 진행 및 결과 검증 Test
}