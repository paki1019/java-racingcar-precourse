package racingcar.model;

public class Rounds {
	private final int rounds;

	private Rounds(String rounds) {
		this.rounds = Integer.parseInt(rounds);
	}

	public static Rounds generate(String input) {
		return new Rounds(input);
	}

	public int getRounds() {
		return rounds;
	}
}
