package racingcar.model;

public class Rounds {
	private static final String REGEX_NUMBER = "-?\\d+";
	private static final int ZERO = 0;
	private final int rounds;

	private Rounds(String input) {
		validate(input);
		this.rounds = Integer.parseInt(input);
	}

	public static Rounds generate(String input) {
		return new Rounds(input);
	}

	private void validate(String input) {
		if (!input.matches(REGEX_NUMBER)) {
			throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
		}

		if (Integer.parseInt(input) <= ZERO) {
			throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
		}
	}

	public int getRounds() {
		return rounds;
	}
}
