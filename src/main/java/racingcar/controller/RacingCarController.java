package racingcar.controller;

import racingcar.model.CarNames;
import racingcar.model.Rounds;
import racingcar.view.InputCarNames;
import racingcar.view.InputRounds;

public class RacingCarController {

	public void run() {
		CarNames carNames = new InputCarNames().readCarNames();
		Rounds rounds = new InputRounds().readRounds();
	}
}
