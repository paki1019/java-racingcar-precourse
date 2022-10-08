package racingcar.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ProgressBarTest {

	@DisplayName("진행바 생성")
	@ParameterizedTest
	@CsvSource(value = {"3:---", "5:-----", "0:''"}, delimiter = ':')
	void generate(int progress, String expected) {
		ProgressBar progressBar = ProgressBar.generate(progress);
		assertThat(progressBar.getProgressBar()).isNotNull();
		assertThat(progressBar.getProgressBar()).isEqualTo(expected);
	}

	@DisplayName("진행바 생성 - 음수 입력")
	@Test
	void generate_negative_input() {
		assertThatThrownBy(() -> ProgressBar.generate(-1))
			.isInstanceOf(IllegalArgumentException.class);
	}
}