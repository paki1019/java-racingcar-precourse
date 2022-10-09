package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarGameTest {

	@DisplayName("자동차 경주 - 결과 반환")
	@Test
	void play() {
		CarNames carNames = CarNames.generate("abc,def");
		RoundCount roundCount = RoundCount.from("3");
		GameResult gameResult = new RacingCarGame(carNames, roundCount).play();
		assertThat(gameResult).isNotNull();
		assertThat(gameResult.getRoundResultList()).hasSize(3);
	}
}