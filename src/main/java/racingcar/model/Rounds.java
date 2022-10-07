package racingcar.model;

public class Rounds {
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
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("시도 횟수는 1 ~ 2,147,483,647의 숫자여야 합니다.");
		}

		if (Integer.parseInt(input) <= ZERO) {
			throw new IllegalArgumentException("시도 횟수는 1 ~ 2,147,483,647의 숫자여야 합니다.");
		}
	}

	public int getRounds() {
		return rounds;
	}
}
