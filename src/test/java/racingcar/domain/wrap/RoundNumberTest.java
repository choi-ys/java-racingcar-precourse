package racingcar.domain.wrap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static racingcar.constants.ErrorMessage.INVALID_ROUND_NUMBER_BOUNDARY_ERROR_MESSAGE;

/**
 * @author : choi-ys
 * @date : 2022-04-24 오후 9:06
 */
@DisplayName("Domain:Wrap:RoundNumber")
class RoundNumberTest {

    @Test
    @DisplayName("int의 원시타입으로 표현되는 현재 라운드 수 포장 객체 생성 Test")
    public void createRoundNumberTest() {
        // Given
        int round = 5;

        // When
        RoundNumber roundNumber = new RoundNumber(round);

        // Then
        assertThat(roundNumber.getCurrentRound()).isEqualTo(round);
    }

    @Test
    @DisplayName("int의 원시타입으로 표현되는 현재 라운드 수 포장 객체 생성 실패 Test")
    public void createRoundNumberFailTest() {
        // Given
        int round = 0;

        // When & Then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RoundNumber(round))
                .withMessageContaining(INVALID_ROUND_NUMBER_BOUNDARY_ERROR_MESSAGE);
    }
}