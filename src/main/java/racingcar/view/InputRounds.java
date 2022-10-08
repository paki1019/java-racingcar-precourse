package racingcar.view;

import racingcar.model.Rounds;

public class InputRounds extends Input<Rounds> {
	@Override
	String message() {
		return "시도할 횟수는 몇회인가요?";
	}

	@Override
	Rounds generate(String input) {
		return Rounds.generate(input);
	}
}
