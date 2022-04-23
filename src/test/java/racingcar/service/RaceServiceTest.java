package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;
import racingcar.domain.CarRaceResult;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

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
        CarRaceResult carRaceResult = raceService.playEachCarSingleRound(car, currentRound);

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
        CarRaceResult carRaceResult = raceService.playEachCarSingleRound(car, currentRound);

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
    public void Test(){
        // Given
    
        // When
    
        // Then
    }

    // TODO : 전체 차량의 단일 라운드 진행 및 결과 검증 Test
    // TODO : 전체 차량의 전체 라운드 진행 및 결과 검증 Test
}