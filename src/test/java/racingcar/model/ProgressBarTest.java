package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ProgressBarTest {

	@DisplayName("진행바 생성")
	@ParameterizedTest
	@CsvSource(value = {"3:---", "5:-----", "0:''"}, delimiter = ':')
	void generate(int value, String expected) {
		ProgressBar progressBar = ProgressBar.from(Progress.from(value));
		assertThat(progressBar.getProgressBar()).isNotNull();
		assertThat(progressBar.getProgressBar()).isEqualTo(expected);
	}
}