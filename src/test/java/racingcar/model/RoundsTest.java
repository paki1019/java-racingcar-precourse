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
	@ValueSource(strings = {"1", "2", "3", "04", "05"})
	void generate(String input) {
		Rounds rounds = Rounds.generate(input);
		assertThat(rounds).isNotNull();
		assertThat(rounds.getRounds()).isEqualTo(Integer.parseInt(input));
	}

	@DisplayName("시도할 횟수 문자열 입력 - 0")
	@ParameterizedTest
	@ValueSource(strings = {"0", "00", "000"})
	void generate_zero(String input) {
		assertThatThrownBy(() -> Rounds.generate(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("시도 횟수는 양수여야 합니다.");
	}


	@DisplayName("시도할 횟수 문자열 입력 - 음수")
	@ParameterizedTest
	@ValueSource(strings = {"-1", "-002", "-999"})
	void generate_negative(String input) {
		assertThatThrownBy(() -> Rounds.generate(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("시도 횟수는 양수여야 합니다.");
	}
}