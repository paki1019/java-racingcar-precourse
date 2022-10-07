package racingcar.controller;

import racingcar.model.InputCarNames;

public class RacingCarController {

	public void run() {
		InputCarNames inputCarNames = new racingcar.view.InputCarNames().readCarNames();
	}
}
