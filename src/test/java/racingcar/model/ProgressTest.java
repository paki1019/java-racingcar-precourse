package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ProgressTest {

	@DisplayName("진행도")
	@ParameterizedTest
	@ValueSource(ints = {0, 3, 6, 9})
	void progress(int count) {
		Progress progress = Progress.from(count);
		assertThat(progress).isNotNull();
		assertThat(progress.getProgress()).isEqualTo(count);
	}

	@DisplayName("진행도 - 음수")
	@ParameterizedTest
	@ValueSource(ints = {-1, -3, -6})
	void progress_negative(int count) {
		assertThatThrownBy(() -> Progress.from(count))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("진행도 - 앞으로 한칸 이동")
	@ParameterizedTest
	@CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
	void tryForward(int givenRandomResult, int expected) {
		Progress progress = Progress.from(0);
		assertRandomNumberInRangeTest(
			() -> assertThat(progress.tryForward()).isEqualTo(Progress.from(expected))
			, givenRandomResult);
	}
}