package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Rounds;

public class InputRounds {
	private Rounds rounds;

	public Rounds readRounds() {
		System.out.println("시도할 횟수는 몇회인가요?");
		String input = Console.readLine();
		return Rounds.generate(input);
	}
}
