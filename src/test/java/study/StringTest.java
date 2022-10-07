package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringTest {
	@Test
	void split() {
		String str = "";
		String[] actual = str.split(",");
		assertThat(actual).hasSize(1);
	}
}
