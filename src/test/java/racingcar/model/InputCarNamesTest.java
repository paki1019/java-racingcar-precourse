package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputCarNamesTest {
	@DisplayName("자동차 이름 문자열 입력")
	@ParameterizedTest
	@CsvSource(value = {"abc:1", "abc,def,ghi:3", "abc,def,ghi,jkl,mno:5"}, delimiter = ':')
	void generate(String input, int expected) {
		InputCarNames inputCarNames = InputCarNames.generate(input);
		assertThat(inputCarNames).isNotNull();
		assertThat(inputCarNames.getCarNames()).hasSize(expected);
	}

	@DisplayName("자동차 이름 문자열 입력 - 빈 목록")
	@ParameterizedTest
	@ValueSource(strings = {"", "  ", "      "})
	void generate_empty_list(String input) {
		assertThatThrownBy(() -> InputCarNames.generate(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("경주할 자동차 이름을 입력해 주세요.");
	}

	@DisplayName("자동차 이름 문자열 입력 - 쉼표로 종료시, 마지막 쉼표 무시")
	@ParameterizedTest
	@CsvSource(value = {"abc,def,:2", "abc,edf,hij,:3"}, delimiter = ':')
	void generate_end_with_comma(String input, int expected) {
		InputCarNames inputCarNames = InputCarNames.generate(input);
		assertThat(inputCarNames).isNotNull();
		assertThat(inputCarNames.getCarNames()).hasSize(expected);
	}

	@DisplayName("자동차 이름 문자열 입력 - 쉼표만 존재시, 빈 입력으로 취급")
	@ParameterizedTest
	@ValueSource(strings = {",", ",,", ",,,,,"})
	void generate_only_comma(String input) {
		assertThatThrownBy(() -> InputCarNames.generate(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("경주할 자동차 이름을 입력해 주세요.");
	}

	@DisplayName("자동차 이름 문자열 입력 - 쉼표로 시작시, 첫번째 이름 공백 입력으로 취급")
	@ParameterizedTest
	@ValueSource(strings = {",abc", ",def,ghi"})
	void generate_start_with_comma(String input) {
		assertThatThrownBy(() -> InputCarNames.generate(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차 이름이 공백일 수는 없습니다.");
	}
}