package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputCarNamesTest {
	@DisplayName("자동차 이름 목록 생성")
	@ParameterizedTest
	@CsvSource(value = {"abc:1", "abc,def,ghi:3", "abc,def,ghi,jkl,mno:5"}, delimiter = ':')
	void generate(String input, int expected) {
		InputCarNames inputCarNames = InputCarNames.generate(input);
		assertThat(inputCarNames).isNotNull();
		assertThat(inputCarNames.getCarNames()).hasSize(expected);
	}

	@DisplayName("자동차 이름 목록 생성 - 빈 목록")
	@ParameterizedTest
	@ValueSource(strings = {"", "  ", "      "})
	void generate_empty_list(String input) {
		assertThatThrownBy(() -> InputCarNames.generate(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차 이름 미입력");
	}
}