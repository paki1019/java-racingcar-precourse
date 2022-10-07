package racingcar.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundsTest {

	@DisplayName("시도할 횟수 문자열 입력")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "3"})
	void generate(String input) {
		Rounds rounds = Rounds.generate(input);
		assertThat(rounds).isNotNull();
		assertThat(rounds.getRounds()).isEqualTo(Integer.parseInt(input));
	}
}