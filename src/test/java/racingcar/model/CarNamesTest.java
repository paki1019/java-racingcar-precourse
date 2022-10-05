package racingcar.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNamesTest {

	@DisplayName("자동차 이름 목록 생성")
	@Test
	void generate() {
		CarNames.generate(Arrays.asList("abc", "def", "ghe"));
		assertThatNoException();
	}
}