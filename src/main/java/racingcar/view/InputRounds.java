package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Rounds;

public class InputRounds {
	private Rounds rounds;
	private boolean retry;

	public Rounds readRounds() {
		do {
			tryReadRounds();
		} while (retry);
		return this.rounds;
	}

	private void tryReadRounds() {
		try {
			System.out.println("시도할 횟수는 몇회인가요?");
			String input = Console.readLine();
			this.rounds = Rounds.generate(input);
			this.retry = false;
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] " + e.getMessage());
			this.retry = true;
		}
	}
}
