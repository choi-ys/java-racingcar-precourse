package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Player;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.wrap.CarNumbers.END_NUMBER;
import static racingcar.domain.wrap.CarNumbers.START_NUMBER;

/**
 * @author : choi-ys
 * @date : 2022/04/22 12:44 오후
 */
@DisplayName("Service:RandomNumber")
public class RandomNumberServiceTest {
    private String namesByComma = "람보르기니,마카롱택시,카카오택시,우라칸,밀레";
    private int roundCount = 5;
    private Player player;
    private Cars cars;
    RandomNumberService randomNumberService;

    @BeforeEach
    void setUp() {
        player = Player.of(namesByComma, roundCount);
        cars = Cars.of(player);
        randomNumberService = new RandomNumberService();
    }

    @Test
    @DisplayName("단일 라운드 진행을 위해, 각 Car 객체에 생성한 난수 할당")
    public void generatedSingleRoundRandomNumberTest() {
        // When
        randomNumberService.generateRandomNumberForSingleRound(cars);

        // Then
        for (int i = 0; i < cars.getCarsSize(); i++) {
            Car carByIndex = cars.getCarByIndex(i);
            List<Integer> carNumberList = carByIndex.getCarNumbers().getNumbers();
            assertThat(carNumberList.get(0)).isBetween(START_NUMBER, END_NUMBER);
        }
    }

//    @Test
//    @DisplayName("전체 라운드 진행을 위해, 각 Car 객체에 생성한 난수 할당")
//    public void generateRandomNumberForAllRound() {
//        // When
//        randomNumberService.generateRandomNumberForAllRound(cars, roundCount);
//
//        // Then
//        for (int i = 0; i < cars.getCarsSize(); i++) {
//            Car carByIndex = cars.getCarByIndex(i);
//            List<Integer> carNumberList = carByIndex.getCarNumbers().getNumbers();
//            for (int j = 0; j < roundCount; j++) {
//                assertThat(carNumberList.get(j)).isBetween(START_NUMBER, END_NUMBER);
//            }
//        }
//    }
}
