package racingcar.model;

public class Rounds {
	private static final int ZERO = 0;
	private final int rounds;

	private Rounds(String rounds) {
		validate(rounds);
		this.rounds = Integer.parseInt(rounds);
	}

	private void validate(String rounds) {
		if (Integer.parseInt(rounds) <= ZERO) {
			throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
		}
	}

	public static Rounds generate(String input) {
		return new Rounds(input);
	}

	public int getRounds() {
		return rounds;
	}
}
