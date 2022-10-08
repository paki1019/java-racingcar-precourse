package racingcar.model;

public class RoundCount {
	private static final int ZERO = 0;
	private final int roundCount;

	private RoundCount(String input) {
		validate(input);
		this.roundCount = Integer.parseInt(input);
	}

	public static RoundCount generate(String input) {
		return new RoundCount(input);
	}

	private void validate(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("시도 횟수는 1 ~ 2,147,483,647의 숫자여야 합니다.");
		}

		if (Integer.parseInt(input) <= ZERO) {
			throw new IllegalArgumentException("시도 횟수는 1 ~ 2,147,483,647의 숫자여야 합니다.");
		}
	}

	public int getRoundCount() {
		return roundCount;
	}
}
