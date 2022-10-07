package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {
	@DisplayName("자동차 이름 생성")
	@ParameterizedTest
	@ValueSource(strings = {"abcde", "12345"})
	void generate_carName(String carName) {
		CarName actual = CarName.generate(carName);
		assertThat(actual).isNotNull();
		assertThat(actual.getCarName()).isEqualTo(carName);
	}

	@DisplayName("자동차 이름 5자 초과")
	@ParameterizedTest
	@ValueSource(strings = {"abcdef", "asdhjsad", "     123434267657     "})
	void generate_carName_over_5letters(String carName) {
		assertThatThrownBy(() -> CarName.generate(carName))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차 이름은 5자 이하만 가능합니다.");
	}

	@DisplayName("자동차 이름 공백")
	@ParameterizedTest
	@ValueSource(strings = {"", "  ", "     "})
	void generate_carName_empty(String carName) {
		assertThatThrownBy(() -> CarName.generate(carName))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차 이름이 공백일 수는 없습니다.");
	}

	@DisplayName("자동차 이름 좌우 공백 무시")
	@ParameterizedTest
	@ValueSource(strings = {"  abcde  ", " 12345 "})
	void generate_carName_trim(String carName) {
		CarName actual = CarName.generate(carName);
		assertThat(actual).isNotNull();
		assertThat(actual.getCarName()).isEqualTo(carName.trim());
	}
}