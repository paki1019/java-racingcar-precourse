package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
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

	@DisplayName("시도할 횟수 문자열 입력 - 숫자 아닌 경우")
	@ParameterizedTest
	@ValueSource(strings = {"abc", "def", "asdgasdg"})
	void generate_not_number(String input) {
		assertThatThrownBy(() -> Rounds.generate(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("시도 횟수는 1 ~ 2,147,483,647의 숫자여야 합니다.");
	}

	@DisplayName("시도할 횟수 문자열 입력 - 0")
	@ParameterizedTest
	@ValueSource(strings = {"0", "00", "000"})
	void generate_zero(String input) {
		assertThatThrownBy(() -> Rounds.generate(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("시도 횟수는 1 ~ 2,147,483,647의 숫자여야 합니다.");
	}

	@DisplayName("시도할 횟수 문자열 입력 - 음수")
	@ParameterizedTest
	@ValueSource(strings = {"-1", "-002", "-999"})
	void generate_negative(String input) {
		assertThatThrownBy(() -> Rounds.generate(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("시도 횟수는 1 ~ 2,147,483,647의 숫자여야 합니다.");
	}

	@DisplayName("시도할 횟수 문자열 입력 - Integer 범위 초과")
	@ParameterizedTest
	@ValueSource(strings = {"2147483648"})
	void generate_out_of_integer(String input) {
		assertThatThrownBy(() -> Rounds.generate(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("시도 횟수는 1 ~ 2,147,483,647의 숫자여야 합니다.");
	}
}