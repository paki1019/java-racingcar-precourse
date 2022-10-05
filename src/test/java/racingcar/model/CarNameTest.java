package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {
	@DisplayName("자동차 이름 5자 초과")
	@Test
	void generate_carName_over_5letters() {
		assertThatThrownBy(() -> CarName.generate("123456"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차 이름은 5자 이하만 가능합니다.");
	}

	@DisplayName("자동차 이름 공백")
	@ParameterizedTest
	@ValueSource(strings = {"", "  ", "     "})
	void generate_carName(String carname) {
		assertThatThrownBy(() -> CarName.generate(carname))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차 이름이 공백일 수는 없습니다.");
	}
}