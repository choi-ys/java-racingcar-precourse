package racingcar.constants;

import static racingcar.domain.wrap.RoundNumber.MINIMUM_ROUND_NUMBER;

/**
 * @author : choi-ys
 * @date : 2022-04-23 오전 12:07
 */
public class ErrorMessage {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR]".concat(" ");

    public static final String CAR_NAME_OVER_LENGTH_ERROR_MESSAGE = ERROR_MESSAGE_PREFIX.concat("1~5 사이의 자동차 이름을 입력하세요");
    public static final String CAR_NAME_INVALID_NUMBER_BOUNDARY_ERROR_MESSAGE = ERROR_MESSAGE_PREFIX.concat("1~9 사이의 숫자만 가능합니다.");

    public static final String INVALID_ROUND_NUMBER_BOUNDARY_ERROR_MESSAGE = ERROR_MESSAGE_PREFIX.concat(String.format("%d 회 이상의 진행 라운드를 입력하세요", MINIMUM_ROUND_NUMBER));
}
